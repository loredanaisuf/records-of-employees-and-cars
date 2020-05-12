package ro.siit.service;


import ro.siit.model.Masina;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ServiceMasina extends ServiceUtilizator {

    public void addCar(Masina masina){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO masini(numar_inmatriculare, marca, anul_fabricatiei,itp, asigurare_rca, asigurare_casco, rovignieta) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, masina.getNrInmatriculare());
            ps.setString(2, masina.getMarca());
            ps.setInt(3, masina.getAnulFabricatiei());
            ps.setString(4, masina.getItp());
            ps.setString(5, masina.getRca());
            ps.setString(6, masina.getCasco());
            ps.setString(7, masina.getRovignieta());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(String nrInmatriculare){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM masini WHERE numar_inmatriculare = ?");
            ps.setString(1, nrInmatriculare);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Masina> getCars(){
        ArrayList<Masina> masini = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM masini");

            while(rs.next()){
                masini.add(new Masina(rs.getString("numar_inmatriculare"), rs.getString("marca"), rs.getInt("anul_fabricatiei"),  rs.getString("itp"), rs.getString("asigurare_rca"), rs.getString("asigurare_casco"), rs.getString("rovignieta")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return masini;
    }

    public Masina getCar(String nrInmatriculare){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM masini WHERE numar_inmatriculare = ?");
            ps.setString(1, nrInmatriculare);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Masina(rs.getString("numar_inmatriculare"), rs.getString("marca"), rs.getInt("anul_fabricatiei"), rs.getString("itp"), rs.getString("asigurare_rca"), rs.getString("asigurare_casco"), rs.getString("rovignieta"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCar(Masina masina){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE masini SET marca = ?, anul_fabricatiei = ?,  itp = ?, asigurare_rca = ?, asigurare_casco = ? , rovignieta = ? WHERE numar_inmatriculare = ?");
            ps.setString(7, masina.getNrInmatriculare());
            ps.setString(1, masina.getMarca());
            ps.setInt(2, masina.getAnulFabricatiei());
            ps.setString(3, masina.getItp());
            ps.setString(4, masina.getRca());
            ps.setString(5, masina.getCasco());
            ps.setString(6, masina.getRovignieta());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
