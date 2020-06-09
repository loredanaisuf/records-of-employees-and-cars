package ro.siit.service;

import ro.siit.model.Utilizator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ServiceUtilizator {

    protected Connection connection;
    public ServiceUtilizator() {
        try {
            Class.forName("org.postgresql.Driver");

            System.out.println("Url-ul pt DB este: " + System.getenv("JDBC_DATABASE_URL"));
            connection = DriverManager.getConnection(System.getenv("JDBC_DATABASE_URL"));

           //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Lori?user=postgres&password=Loredana12");
            } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Utilizator> getUsers(String companyName){
        ArrayList<Utilizator> utilizatori = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM utilizatori WHERE firma = ?");
            ps.setObject(1, companyName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                System.out.println(new Utilizator(UUID.fromString(rs.getObject("id_utilizator").toString()), rs.getString("firma"),rs.getString("nume"), rs.getString("prenume"), rs.getString("telefon"), rs.getString("id_masina"), rs.getString("email"), rs.getString("parola")));
                utilizatori.add(new Utilizator(UUID.fromString(rs.getObject("id_utilizator").toString()), rs.getString("firma"),rs.getString("nume"), rs.getString("prenume"), rs.getString("telefon"), rs.getString("id_masina"), rs.getString("email"), rs.getString("parola")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //utilizatori.add(new Utilizator(UUID.randomUUID(), "maria", "maria"));
        //utilizatori.add(new Utilizator(UUID.randomUUID(), "ioana", "ioana"));

        return utilizatori;
    }

    public void addUser(Utilizator utilizator){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO utilizatori(id_utilizator, firma, id_masina, nume, prenume, telefon, email, parola) VALUES (?, ?, ?, ?, ?,?,?,?)");
            ps.setObject(1, utilizator.getId());
            ps.setString(2,utilizator.getFirma());
            ps.setString(3, utilizator.getId_masina());
            ps.setString(4, utilizator.getNume());
            ps.setString(5, utilizator.getPrenume());
            ps.setString(6, utilizator.getTelefon());
            ps.setString(7, utilizator.getEmail());
            ps.setString(8, utilizator.getParola());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(UUID id){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM utilizatori WHERE id_utilizator = ?");
            ps.setObject(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Utilizator getUser(UUID idUser){
        try {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM utilizatori WHERE id_utilizator = ?");
            ps.setObject(1, idUser);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Utilizator(UUID.fromString(rs.getObject("id_utilizator").toString()), rs.getString("firma"),rs.getString("nume"), rs.getString("prenume"), rs.getString("telefon"), rs.getString("id_masina"), rs.getString("email"), rs.getString("parola"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateUser(Utilizator utilizator){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE utilizatori SET id_masina = ?, firma = ?, nume = ?, prenume = ?, telefon = ?, email = ?, parola = ?  WHERE id_utilizator = ?");
            ps.setObject(8, utilizator.getId());
            ps.setString(1, utilizator.getId_masina());
            ps.setString(2,utilizator.getFirma());
            ps.setString(3, utilizator.getNume());
            ps.setString(4, utilizator.getPrenume());
            ps.setString(5, utilizator.getTelefon());
            ps.setString(6, utilizator.getEmail());
            ps.setString(7, utilizator.getParola());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Utilizator checkCredentialsUser(String username, String password){

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM utilizatori WHERE email = ? AND parola = ?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Utilizator utilizator = new Utilizator(UUID.fromString(rs.getObject("id_utilizator").toString()), rs.getString("firma"), rs.getString("nume"), rs.getString("prenume"), rs.getString("telefon"), rs.getString("id_masina"), rs.getString("email"),rs.getString("parola"));
                System.out.println("user from checkcredintial: " +  utilizator);
                return utilizator;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean usernameExists(String username){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM utilizatori WHERE email = ?");
            ps.setString(1, username);

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
    @Override
    protected void finalize() throws Throwable {
        this.connection.close();
    }
}
