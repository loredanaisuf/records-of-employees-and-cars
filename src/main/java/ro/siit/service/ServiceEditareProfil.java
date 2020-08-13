package ro.siit.service;

import ro.siit.crypt.EncryptDecryptPassword;
import ro.siit.model.Utilizator;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class ServiceEditareProfil extends ServiceUtilizator {

    public void updateUser(UUID id, String nume, String prenume, String email, String parola, String telefon){
        EncryptDecryptPassword edp= null;
        try {
            edp = new EncryptDecryptPassword();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String password= parola;
        String encryptedPassword=edp.encrypt(password);
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE utilizatori SET nume = ?, prenume = ?, email = ?, parola = ?, telefon = ?  WHERE id_utilizator = ?");
            ps.setObject(6, id);
            ps.setString(1, nume);
            ps.setString(2, prenume);
            ps.setString(3, email);
            ps.setString(4, encryptedPassword);
            ps.setString(5, telefon);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAdmin(String firma, String nume, String prenume, String email, String parola, String telefon){
        EncryptDecryptPassword edp= null;
        try {
            edp = new EncryptDecryptPassword();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String password= parola;
        String encryptedPassword=edp.encrypt(password);
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE companii SET nume_admin = ?, prenume_admin = ?, email = ?, parola = ?, telefon = ?  WHERE nume_firma = ?");
            ps.setString(6, firma);
            ps.setString(1,nume);
            ps.setString(2, prenume);
            ps.setString(3, email);
            ps.setString(4, encryptedPassword);
            ps.setString(5, telefon);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}