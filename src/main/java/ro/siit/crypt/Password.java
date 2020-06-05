package ro.siit.crypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Password {
    private static List<ModelPassword> modelPasswords = new ArrayList<>();

    public static void addPasword(String table, String email, String password, String encrypedPassword){
        modelPasswords.add(new ModelPassword(table,email,password,encrypedPassword));
    }

    private static List<String> prepareForSave(){
        List<String> stringPasswordsList = new ArrayList<>();
        for(ModelPassword storePassword:modelPasswords){
            stringPasswordsList.add(storePassword.toString());
        }
        return stringPasswordsList;
    }

    public static void save(){
        Path passwordsDB = Paths.get("passwordsDB");
        System.out.println("Path for save passwords: " + passwordsDB);
        System.out.println("Password: " + prepareForSave());
        try {
            Files.write(passwordsDB,prepareForSave());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
