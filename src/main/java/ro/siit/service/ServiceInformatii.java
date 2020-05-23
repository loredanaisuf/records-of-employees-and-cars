package ro.siit.service;

import ro.siit.model.InformatiiMasina;
import ro.siit.model.InformatiiPtGrafic;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ServiceInformatii extends ServiceUtilizator {

    public List<InformatiiPtGrafic> getNumberOfKM(String nrInmatriculare){
        List<InformatiiPtGrafic> informatiiPtGraficList = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM informatii_masini WHERE numar_inmatriculare = ?");
            ps.setString(1, nrInmatriculare);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                informatiiPtGraficList.add(new InformatiiPtGrafic(rs.getString("data"), rs.getString("numar_km")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return informatiiPtGraficList;
    }

    public List<InformatiiPtGrafic> getQuantityOfFuel(String nrInmatriculare){
        List<InformatiiPtGrafic> informatiiPtGraficList = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM informatii_masini WHERE numar_inmatriculare = ?");
            ps.setString(1, nrInmatriculare);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                informatiiPtGraficList.add(new InformatiiPtGrafic(rs.getString("data"), rs.getString("cantitate_motorina")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return informatiiPtGraficList;
    }

    public List<InformatiiPtGrafic> getConsumption(String nrInmatriculare){
        List<InformatiiPtGrafic> informatiiPtGraficList = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM informatii_masini WHERE numar_inmatriculare = ?");
            ps.setString(1, nrInmatriculare);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                informatiiPtGraficList.add(new InformatiiPtGrafic(rs.getString("data"), rs.getString("consum")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return informatiiPtGraficList;
    }

    public List<InformatiiMasina> getInformation(String nrInmatriculare){
        List<InformatiiMasina> informatiiMasinaList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM informatii_masini WHERE numar_inmatriculare = ?");
            ps.setString(1, nrInmatriculare);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                informatiiMasinaList.add(new InformatiiMasina((UUID) rs.getObject("id"), nrInmatriculare, rs.getString("data"), rs.getFloat("numar_km"), rs.getInt("cantitate_motorina"), rs.getFloat("consum")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return informatiiMasinaList;
    }

    public float getNrOfKm(String firstDate, String secondDate){
        float nrOfKm = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM informatii_masini WHERE data >= ? AND data <= ?");
            ps.setString(1, firstDate);
            ps.setString(2,secondDate);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                nrOfKm += rs.getFloat("numar_km");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nrOfKm;
    }

    public int getFuel(String firstDate, String secondDate){
        int fuel = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM informatii_masini WHERE data >= ? AND data <= ?");
            ps.setString(1, firstDate);
            ps.setString(2,secondDate);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                fuel += rs.getInt("cantitate_motorina");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fuel;
    }

    public float getConsumption(String firstDate, String secondDate){
        float consumtion = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM informatii_masini WHERE data >= ? AND data <= ?");
            ps.setString(1, firstDate);
            ps.setString(2,secondDate);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                consumtion += rs.getFloat("consum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consumtion;
    }
}
