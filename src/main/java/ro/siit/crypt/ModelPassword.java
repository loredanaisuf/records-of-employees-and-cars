package ro.siit.crypt;

public class ModelPassword {
    private String table;
    private String email;
    private String password;
    private String encrypedPassword;

    public ModelPassword(String table, String email, String password, String encrypedPassword) {
        this.table = table;
        this.email = email;
        this.password = password;
        this.encrypedPassword = encrypedPassword;
    }

    @Override
    public String toString() {
        return this.table + " ; " + this.email + " ; " + this.password + " ; " +this.encrypedPassword;
    }
}
