package ro.siit.service;

import ro.siit.model.Coordonate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceCoordonate extends ServiceUtilizator {

    public void addCoordinates(Coordonate coordonate){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO coordonate(nume_firma, nume, nr_inmatriculare, latitudine, longitudine) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1,coordonate.getNumeFirma());
            ps.setString(2, coordonate.getNume());
            ps.setString(3, coordonate.getNrInmatriculare());
            ps.setString(4,coordonate.getLatitudine());
            ps.setString(5, coordonate.getLongitudine());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Coordonate> getCoordinates(String nume, String nrInmatriculare){
        List<Coordonate> coordonateList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM coordonate WHERE nume = ? AND nr_inmatriculare = ?");
            ps.setString(1, nume);
            ps.setString(2,nrInmatriculare);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                coordonateList.add(new Coordonate(rs.getString("nume_firma"), rs.getString("nume"), rs.getString("nr_inmatriculare"), rs.getString("latitudine"), rs.getString("longitudine")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coordonateList;
    }

    public List<Coordonate> getAllCoordinates(String numeFirma){
        List<Coordonate> coordonateList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM coordonate WHERE nume_firma = ?");
            ps.setString(1,numeFirma);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                coordonateList.add(new Coordonate(rs.getString("nume_firma"), rs.getString("nume"), rs.getString("nr_inmatriculare"), rs.getString("latitudine"), rs.getString("longitudine")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coordonateList;
    }
}
