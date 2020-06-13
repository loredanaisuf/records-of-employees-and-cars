package ro.siit;

import ro.siit.model.Coordonate;
import ro.siit.service.ServiceCoordonate;

import java.util.List;


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

        ServiceCoordonate serviceCoordonate = new ServiceCoordonate();
        List<Coordonate> coordonateList = serviceCoordonate.getCoordinatesByDate("GJ99YIL", "2020-06-08", "2020-06-10");
        System.out.println(coordonateList);

    }
}
