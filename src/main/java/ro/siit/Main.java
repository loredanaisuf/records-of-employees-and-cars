package ro.siit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ro.siit.model.Coordonate;
import ro.siit.model.InformatiiMasina;
import ro.siit.service.ServiceCoordonate;
import ro.siit.service.ServiceInformatii;
import ro.siit.service.ServiceMasina;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Main {
    public static void main(String[] args) {
//        ServiceUtilizator serviceUtilizator = new ServiceUtilizator();
//        List<Utilizator> utilizators = serviceUtilizator.getUsers("SC ISUFMAR TRANS SRL");
//        System.out.println(utilizators);

//        String[] spitDate = new String[3];
//        spitDate = ("2020-05-22").split("-");
//        System.out.println(Integer.parseInt(spitDate[1])==5);
//
//        EncryptDecryptPassword td= null;
//        try {
//            td = new EncryptDecryptPassword();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        String target="admin";
//        String target2 ="test";
//        String encrypted=td.encrypt(target);
//        String decrypted=td.decrypt(encrypted);
//
//        Password.addPasword("companii","lori",target,encrypted);
//        Password.save();
//        System.out.println("String To Encrypt: "+ target);
//        System.out.println("Encrypted String:" + encrypted);
//        System.out.println("Decrypted String:" + decrypted);
//
//        String encrypted1=td.encrypt(target);
//        System.out.println("Encrypted 2 String: "+ encrypted1);

//        LocalDate date = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        System.out.println(date.format(formatter));
//        System.out.println(date.format(formatter1));

//        ServiceCoordonate serviceCoordonate = new ServiceCoordonate();
//        List<Coordonate> coordonateList = serviceCoordonate.getCoordinatesByDate("GJ99YIL", "2020-06-08", "2020-06-10");
//        System.out.println(coordonateList);

//        ServiceInformatii serviceInformatii = new ServiceInformatii();
//        ServiceMasina serviceMasina = new ServiceMasina();
        List<InformatiiMasina> informatiiMasinaList = new ArrayList<>();

        informatiiMasinaList.add(new InformatiiMasina(UUID.randomUUID(), "GJ99YIL", "25/04/2020",  54.0f, 20, 21.0f));
        informatiiMasinaList.add(new InformatiiMasina(UUID.randomUUID(), "GJ99YIL", "24/04/2020",  84.0f, 30, 21.0f));
        informatiiMasinaList.add(new InformatiiMasina(UUID.randomUUID(), "GJ99YIL", "23/04/2020",  74.0f, 27, 21.0f));
        byte[] bits = Main.getXLSFile(informatiiMasinaList);
    }
    public static byte[] getXLSFile(List<InformatiiMasina> informatiiMasinaList){
        // Using XSSF for xlsx format, for xls use HSSF
        Workbook workbook = new XSSFWorkbook();

        Sheet studentsSheet = workbook.createSheet("Informatii masini");

        int rowIndex = 0;
        for(InformatiiMasina informatiiMasina : informatiiMasinaList){
            Row row = studentsSheet.createRow(rowIndex++);
            int cellIndex = 0;
            //first place in row is name
            row.createCell(cellIndex++).setCellValue(informatiiMasina.getNumarInmariculare());

            //second place in row is marks in maths
            row.createCell(cellIndex++).setCellValue(informatiiMasina.getNumarKm());

            //third place in row is marks in Science
            row.createCell(cellIndex++).setCellValue(informatiiMasina.getCantitate());

            //fourth place in row is marks in English
            row.createCell(cellIndex++).setCellValue(informatiiMasina.getConsum());

            //fifth place in row is marks in English
            row.createCell(cellIndex++).setCellValue(informatiiMasina.getData());

        }
        //write this workbook in excel file.
        try {
            FileOutputStream fos = new FileOutputStream("fisier.xlsx");
            workbook.write(fos);
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = (workbook.toString()).getBytes();
        return bytes;
    }
}
