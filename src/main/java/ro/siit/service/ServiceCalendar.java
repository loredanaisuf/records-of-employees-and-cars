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

    public List<Event> getDatesFromDB(){
        List<Event> listOfDates = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM masini");

            Statement st1 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM remorci");

            while (rs.next()){
                String nameAndItp = "M: " + rs.getString("numar_inmatriculare") + ": Itp";
                listOfDates.add(new Event("M",nameAndItp, rs.getDate("itp")));
                String nameAndRca = "M: " + rs.getString("numar_inmatriculare") + ": RCA";
                listOfDates.add(new Event("M",nameAndRca, rs.getDate("asigurare_rca")));
                String nameAndCasco = "M: " + rs.getString("numar_inmatriculare") + ": CASCO";
                listOfDates.add(new Event("M",nameAndCasco, rs.getDate("asigurare_casco")));
                String nameAndRovignieta = "M: " + rs.getString("numar_inmatriculare") + ": Rovignieta";
                listOfDates.add(new Event("M",nameAndRovignieta, rs.getDate("rovignieta")));
            }

            while(rs1.next()){
                String name = "R: " + rs1.getString("numar_inmatriculare_remorca") + ": ITP";
                listOfDates.add(new Event("R",name, rs1.getDate("itp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfDates;
    }
}
