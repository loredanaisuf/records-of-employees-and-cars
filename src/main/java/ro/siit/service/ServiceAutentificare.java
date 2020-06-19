package ro.siit.service;

import ro.siit.model.TabelAutentificare;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceAutentificare extends ServiceUtilizator {
    public void addUser(TabelAutentificare tabelAutentificare){
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

    public void deleteUser(String selector){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM utilizatori_auth WHERE selector = ?");
            ps.setString(1,selector);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(String selector, String validator, String id){
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

    public TabelAutentificare getUser(String selector, String validator){
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

    public void addAdmin(TabelAutentificare tabelAutentificare){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO companii_auth(id, selector, validator, user_id) VALUES (?, ?, ?, ?)");
            ps.setString(1,tabelAutentificare.getId());
            ps.setString(2,tabelAutentificare.getSelector());
            ps.setString(3,tabelAutentificare.getValidator());
            ps.setString(4,tabelAutentificare.getUserId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAdmin(String selector){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM companii_auth WHERE selector = ?");
            ps.setString(1,selector);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAdmin(String selector, String validator, String id){
        System.out.println("From update entity: " + selector + ", " + validator + ", " + id);
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE companii_auth SET selector = ?, validator = ? WHERE id = ?");
            ps.setString(1,selector);
            ps.setString(2,validator);
            ps.setString(3,id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TabelAutentificare getAdmin(String selector, String validator){
        try {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM companii_auth WHERE selector = ? AND validator = ?");
            ps.setString(1, selector);
            ps.setString(2,validator);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new TabelAutentificare(rs.getString("id"),rs.getString("selector"), rs.getString("validator"), rs.getString("admin_id"));
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