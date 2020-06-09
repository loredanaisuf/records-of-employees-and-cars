package ro.siit.service;

import ro.siit.model.Event;
import ro.siit.model.Utilizator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceCalendar extends ServiceUtilizator {

    public List<Event> getDatesFromDB(String numeFirma){
        List<Event> listOfDates = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM masini WHERE firma = ?");
            ps.setString(1,numeFirma);
            ResultSet rs = ps.executeQuery();

            PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM remorci WHERE firma = ?");
            ps1.setString(1,numeFirma);
            ResultSet rs1 = ps1.executeQuery();

            while (rs.next()){
                String nameAndItp = "ITP: " + rs.getString("numar_inmatriculare") + ": M";
                listOfDates.add(new Event("M",nameAndItp, rs.getString("itp")));
                String nameAndRca = "RCA: " + rs.getString("numar_inmatriculare") + ": M";
                listOfDates.add(new Event("M",nameAndRca, rs.getString("asigurare_rca")));
                String nameAndCasco = "CASCO: " + rs.getString("numar_inmatriculare") + ": M";
                listOfDates.add(new Event("M",nameAndCasco, rs.getString("asigurare_casco")));
                String nameAndRovignieta = "Rovignieta: " + rs.getString("numar_inmatriculare") + ": M";
                listOfDates.add(new Event("M",nameAndRovignieta, rs.getString("rovignieta")));
            }

            while(rs1.next()){
                String name = "ITP: " + rs1.getString("numar_inmatriculare_remorca") + ": R";
                listOfDates.add(new Event("R",name, rs1.getString("itp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfDates;
    }

}
