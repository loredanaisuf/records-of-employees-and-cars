package ro.siit.service;

import ro.siit.model.Coordonate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ServiceCoordonate extends ServiceUtilizator {

    public void addCoordinates(Coordonate coordonate){
        System.out.println("from addCoordinates");
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String data = date.format(formatter);

        try{
            PreparedStatement ps1 = connection.prepareStatement("UPDATE coordonatele_curente SET latitudine = ? WHERE nr_inmatriculare = ? ");
            ps1.setString(1, coordonate.getLatitudine());
            ps1.setString(2, coordonate.getNrInmatriculare());
            ps1.executeUpdate();
            PreparedStatement ps2 = connection.prepareStatement("UPDATE coordonatele_curente SET longitudine = ? WHERE nr_inmatriculare = ? ");
            ps2.setString(1, coordonate.getLongitudine());
            ps2.setString(2, coordonate.getNrInmatriculare());
            ps2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO coordonate(nume_firma, nume, nr_inmatriculare, latitudine, longitudine, data) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, coordonate.getNumeFirma());
            ps.setString(2, coordonate.getNume());
            ps.setString(3, coordonate.getNrInmatriculare());
            ps.setString(4, coordonate.getLatitudine());
            ps.setString(5, coordonate.getLongitudine());
            ps.setString(6, date.format(formatter));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Coordonate> getCoordinatesByDate(String nrInmatriculare, String data1, String data2){
        List<Coordonate> coordonateList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM coordonate WHERE nr_inmatriculare = ? AND data >= ? AND data <= ?");
            ps.setString(1,nrInmatriculare);
            ps.setString(2,data1);
            ps.setString(3,data2);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                coordonateList.add(new Coordonate(rs.getString("nume_firma"), rs.getString("nume"), rs.getString("nr_inmatriculare"), rs.getString("latitudine"), rs.getString("longitudine")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coordonateList;
    }

    public Coordonate getLatestCoordinetesForCar(String nrInmatriculare){
        Coordonate coordonatesCar = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM coordonatele_curente WHERE nr_inmatriculare = ?");
            ps.setString(1,nrInmatriculare);
            ResultSet rs = ps.executeQuery();

            rs.next();
            if(!rs.getString("latitudine").equals("")) {
                coordonatesCar = new Coordonate(rs.getString("nume_firma"), rs.getString("nume"), rs.getString("nr_inmatriculare"), rs.getString("latitudine"), rs.getString("longitudine"));
            } else{
                coordonatesCar = new Coordonate(rs.getString("nume_firma"), rs.getString("nume"), rs.getString("nr_inmatriculare"),"0","0");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coordonatesCar;
    }

    public List<Coordonate> getAllCoordinates(String numeFirma){
        List<Coordonate> coordonateList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM coordonatele_curente WHERE nume_firma = ?");
            ps.setString(1,numeFirma);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                if(!rs.getString("latitudine").equals("")){
                    coordonateList.add(new Coordonate(rs.getString("nume_firma"), rs.getString("nume"), rs.getString("nr_inmatriculare"), rs.getString("latitudine"), rs.getString("longitudine")));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coordonateList;
    }

}