package ro.siit.model;

public class Administrator {
    private String firma;
    private String email;
    private String parola;
    private String nume;
    private String prenume;
    private String telefon;
    private String cod;

    public Administrator(String firma, String email, String parola, String nume, String prenume, String telefon, String cod) {
        this.firma = firma;
        this.email = email;
        this.parola = parola;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.cod = cod;
    }

    public String getFirma() {
        return firma;
    }

    public String getEmail() {
        return email;
    }

    public String getParola() {
        return parola;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getCod(){return cod;}

    @Override
    public String toString() {
        return "Administrator{" +
                "numeFirma='" + firma + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                ", numeAdmin='" + nume + '\'' +
                ", prenumeAdmin='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
