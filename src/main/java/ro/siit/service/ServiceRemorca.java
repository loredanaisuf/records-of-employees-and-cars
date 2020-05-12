package ro.siit.service;

import ro.siit.model.Remorca;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ServiceRemorca extends ServiceUtilizator {

    public List<Remorca> getTrails(){
        ArrayList<Remorca> remorci = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM remorci");
            while(rs.next()){
                remorci.add(new Remorca(rs.getString("numar_inmatriculare_remorca"), rs.getString("numar_inmatriculare_masina"),rs.getInt("anul_fabricatiei"), rs.getString("itp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return remorci;
    }

    public Remorca getTrail(String idRemorca){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM remorci WHERE numar_inmatriculare_remorca = ?");
            ps.setString(1, idRemorca);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Remorca(idRemorca,rs.getString("numar_inmatriculare_masina"), rs.getInt("anul_fabricatiei"), rs.getString("itp"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addTrail(Remorca remorca){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO remorci(numar_inmatriculare_remorca, numar_inmatriculare_masina, anul_fabricatiei, itp) VALUES (?, ? ,?, ?)");
            ps.setString(1, remorca.getNrInmatriculareRemorca());
            ps.setString(2, remorca.getNrInmatriculareMasina());
            ps.setInt(3, remorca.getAnulFabricatiei());
            ps.setString(4, remorca.getItp());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTrail(String idRemorca){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM remorci WHERE numar_inmatriculare_remorca = ?");
            ps.setString(1, idRemorca);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTrail(Remorca remorca){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE remorci SET numar_inmatriculare_masina = ?, anul_fabricatiei = ?, itp = ? WHERE numar_inmatriculare_remorca = ?");
            ps.setString(4, remorca.getNrInmatriculareRemorca());
            ps.setString(1,remorca.getNrInmatriculareMasina());
            ps.setInt(2, remorca.getAnulFabricatiei());
            ps.setString(3, remorca.getItp());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
