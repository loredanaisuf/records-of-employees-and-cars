package ro.siit.service;

import ro.siit.model.Pontaj;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class ServicePontaj extends ServiceUtilizator {
    public void addDate(Pontaj pontaj){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO pontaj(id_angajat, nume_prenume, data, nr_ore) VALUES(?,?,?,?)");
            ps.setObject(1,pontaj.getIdAngajat());
            ps.setString(2,pontaj.getNumePrenume());
            ps.setString(3,pontaj.getData());
            ps.setInt(4,pontaj.getNumarOre());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pontaj> getDates(UUID id){
        List<Pontaj> listOfDates = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM pontaj WHERE id_angajat = ?");
            ps.setObject(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                listOfDates.add(new Pontaj(UUID.fromString(rs.getObject("id_angajat").toString()), rs.getString("nume_prenume"), rs.getString("data"), rs.getInt("nr_ore")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfDates;
    }

    public int getNumberOfHours(UUID id){
        int nrOfHours=0;
        PreparedStatement ps = null;
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String[] spitDate = new String[3];
        try {
            ps = connection.prepareStatement("SELECT * FROM pontaj WHERE id_angajat = ?");
            ps.setObject(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                spitDate = (rs.getString("data")).split("-");
                if(Integer.parseInt(spitDate[0]) == currentYear && Integer.parseInt(spitDate[1]) == currentMonth ){
                    nrOfHours += rs.getInt("nr_ore");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nrOfHours;
    }

}