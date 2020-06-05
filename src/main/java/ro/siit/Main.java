package ro.siit;

import ro.siit.crypt.EncryptDecryptPassword;
import ro.siit.crypt.Password;



public class Main {
    public static void main(String[] args) {
//        ServiceUtilizator serviceUtilizator = new ServiceUtilizator();
//        List<Utilizator> utilizators = serviceUtilizator.getUsers("fd");
//        System.out.println(utilizators);

        String[] spitDate = new String[3];
        spitDate = ("2020-05-22").split("-");
        System.out.println(Integer.parseInt(spitDate[1])==5);

        EncryptDecryptPassword td= null;
        try {
            td = new EncryptDecryptPassword();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String target="admin";
        String target2 ="test";
        String encrypted=td.encrypt(target);
        String decrypted=td.decrypt(encrypted);

        Password.addPasword("companii","lori",target,encrypted);
        Password.save();
        System.out.println("String To Encrypt: "+ target);
        System.out.println("Encrypted String:" + encrypted);
        System.out.println("Decrypted String:" + decrypted);

        String encrypted1=td.encrypt(target);
        System.out.println("Encrypted 2 String: "+ encrypted1);
    }
}
