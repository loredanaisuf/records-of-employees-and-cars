package ro.siit.service;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ro.siit.model.InformatiiMasina;
import ro.siit.model.Masina;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ServiceMasina extends ServiceUtilizator {

    public void addCar(Masina masina){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO masini(numar_inmatriculare, firma, marca, anul_fabricatiei,itp, asigurare_rca, asigurare_casco, rovignieta) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, masina.getNrInmatriculare());
            ps.setString(2,masina.getFirma());
            ps.setString(3, masina.getMarca());
            ps.setInt(4, masina.getAnulFabricatiei());
            ps.setString(5, masina.getItp());
            ps.setString(6, masina.getRca());
            ps.setString(7, masina.getCasco());
            ps.setString(8, masina.getRovignieta());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addInf(InformatiiMasina informatiiMasina){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO informatii_masini(id, numar_inmatriculare, data, numar_km, cantitate_motorina, consum) VALUES (?,?,?,?,?,?)");
            ps.setObject(1, informatiiMasina.getId());
            ps.setString(2, informatiiMasina.getNumarInmariculare());
            ps.setString(3, informatiiMasina.getData());
            ps.setFloat(4, informatiiMasina.getNumarKm());
            ps.setInt(5, informatiiMasina.getCantitate());
            ps.setFloat(6,informatiiMasina.getConsum());
            ps.executeUpdate();

            System.out.println("from serviceMasina, addInf");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteCar(String nrInmatriculare){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM masini WHERE numar_inmatriculare = ?");
            ps.setString(1, nrInmatriculare);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Masina> getCars(String companyName){
        ArrayList<Masina> masini = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM masini WHERE firma = ?");
            ps.setObject(1, companyName);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                masini.add(new Masina(rs.getString("numar_inmatriculare"), rs.getString("firma"), rs.getString("marca"), rs.getInt("anul_fabricatiei"),  rs.getString("itp"), rs.getString("asigurare_rca"), rs.getString("asigurare_casco"), rs.getString("rovignieta")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return masini;
    }

    public Masina getCar(String nrInmatriculare){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM masini WHERE numar_inmatriculare = ?");
            ps.setString(1, nrInmatriculare);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Masina(rs.getString("numar_inmatriculare"),rs.getString("firma"), rs.getString("marca"), rs.getInt("anul_fabricatiei"), rs.getString("itp"), rs.getString("asigurare_rca"), rs.getString("asigurare_casco"), rs.getString("rovignieta"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCar(Masina masina){
        System.out.println("from updateCar: " + masina);
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE masini SET marca = ?, firma = ?, anul_fabricatiei = ?,  itp = ?, asigurare_rca = ?, asigurare_casco = ? , rovignieta = ? WHERE numar_inmatriculare = ?");
            ps.setString(8, masina.getNrInmatriculare());
            ps.setString(1, masina.getMarca());
            ps.setString(2,masina.getFirma());
            ps.setInt(3, masina.getAnulFabricatiei());
            ps.setString(4, masina.getItp());
            ps.setString(5, masina.getRca());
            ps.setString(6, masina.getCasco());
            ps.setString(7, masina.getRovignieta());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Workbook getXLSFile(List<InformatiiMasina> informatiiMasinaList){
        String[] columns = {"Nr inmatriculare", "Numarul de km", "Cantitatea de motorina", "Consumul", "Data"};

        // Using XSSF for xlsx format, for xls use HSSF
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Informatii masini");
        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
//        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        int rowIndex = 0;

        // Create a Row
        Row headerRow = sheet.createRow(rowIndex++);
        // Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        for(InformatiiMasina informatiiMasina : informatiiMasinaList){
            Row row = sheet.createRow(rowIndex++);
            int cellIndex = 0;
            //first place in row
            row.createCell(cellIndex++).setCellValue(informatiiMasina.getNumarInmariculare());

            //second place in row
            row.createCell(cellIndex++).setCellValue(informatiiMasina.getNumarKm());

            //third place in row
            row.createCell(cellIndex++).setCellValue(informatiiMasina.getCantitate());

            //fourth place in row
            row.createCell(cellIndex++).setCellValue(informatiiMasina.getConsum());

            //fifth place in row
            row.createCell(cellIndex++).setCellValue(informatiiMasina.getData());

        }

        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        return workbook;
    }

}