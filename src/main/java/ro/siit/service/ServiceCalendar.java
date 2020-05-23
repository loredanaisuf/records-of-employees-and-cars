package ro.siit.service;

import ro.siit.model.Event;
import ro.siit.model.Utilizator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceCalendar {
    protected Connection connection;
    public ServiceCalendar() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Lori?user=postgres&password=Loredana12");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

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
                String nameAndItp = "M: " + rs.getString("numar_inmatriculare") + ": Itp";
                listOfDates.add(new Event("M",nameAndItp, rs.getString("itp")));
                String nameAndRca = "M: " + rs.getString("numar_inmatriculare") + ": RCA";
                listOfDates.add(new Event("M",nameAndRca, rs.getString("asigurare_rca")));
                String nameAndCasco = "M: " + rs.getString("numar_inmatriculare") + ": CASCO";
                listOfDates.add(new Event("M",nameAndCasco, rs.getString("asigurare_casco")));
                String nameAndRovignieta = "M: " + rs.getString("numar_inmatriculare") + ": Rovignieta";
                listOfDates.add(new Event("M",nameAndRovignieta, rs.getString("rovignieta")));
            }

            while(rs1.next()){
                String name = "R: " + rs1.getString("numar_inmatriculare_remorca") + ": ITP";
                listOfDates.add(new Event("R",name, rs1.getString("itp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfDates;
    }
}
