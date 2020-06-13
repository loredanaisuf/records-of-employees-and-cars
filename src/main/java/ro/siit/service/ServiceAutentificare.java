package ro.siit.service;

import ro.siit.model.TabelAutentificare;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceAutentificare extends ServiceUtilizator {
    public void addEntity(TabelAutentificare tabelAutentificare){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO utilizatori_auth(id, selector, validator, user_id) VALUES (?, ?, ?, ?)");
            ps.setString(1,tabelAutentificare.getId());
            ps.setString(2,tabelAutentificare.getSelector());
            ps.setString(3,tabelAutentificare.getValidator());
            ps.setString(4,tabelAutentificare.getUserId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEntity(String selector){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM utilizatori_auth WHERE selector = ?");
            ps.setString(1,selector);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEntity(String selector, String validator, String id){
        System.out.println("From update entity: " + selector + ", " + validator + ", " + id);
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE utilizatori_auth SET selector = ?, validator = ? WHERE id = ?");
            ps.setString(1,selector);
            ps.setString(2,validator);
            ps.setString(3,id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TabelAutentificare getEntity(String selector, String validator){
        try {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM utilizatori_auth WHERE selector = ? AND validator = ?");
            ps.setString(1, selector);
            ps.setString(2,validator);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new TabelAutentificare(rs.getString("id"),rs.getString("selector"), rs.getString("validator"), rs.getString("user_id"));
            } else {
                return null;
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}