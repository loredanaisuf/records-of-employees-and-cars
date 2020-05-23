package ro.siit.service;

import ro.siit.model.Administrator;
import ro.siit.model.Utilizator;

import java.sql.*;
import java.util.UUID;

public class ServiceAdministrator {
    protected Connection connection;
    public ServiceAdministrator() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Lori?user=postgres&password=Loredana12");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Administrator getAdmin(String firma){
        try {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM companii WHERE nume_firma = ?");
            ps.setObject(1, firma);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Administrator(rs.getString("nume_firma"),rs.getString("email"), rs.getString("parola"), rs.getString("nume_admin"), rs.getString("prenume_admin"), rs.getString("telefon"), rs.getString("cod"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addAdmin(Administrator administrator){
        try {
            System.out.println("From add admin");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO companii(nume_firma, email, parola, nume_admin, prenume_admin,telefon,cod) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setObject(1, administrator.getFirma());
            ps.setString(2,administrator.getEmail());
            ps.setString(3, administrator.getParola());
            ps.setString(4, administrator.getNume());
            ps.setString(5, administrator.getPrenume());
            ps.setString(6, administrator.getTelefon());
            ps.setString(7, administrator.getCod());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Administrator checkCredentialsAdmin(String username, String password){
        System.out.println("From credentials admin, email: " + username + " parola: " + password);
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM companii WHERE email = ? AND parola = ?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Administrator(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean companyExists(String numeFirma){
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM companii WHERE nume_firma = ?");
            ps.setString(1, numeFirma);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean emailExists(String email){
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM companii WHERE email = ?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
