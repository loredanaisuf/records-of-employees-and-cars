package ro.siit.model;

import java.util.UUID;

public class Utilizator {
    private UUID id;
    private String nume;
    private String prenume;
    private String telefon;
    private String id_masina;
    private String email;
    private String parola;

    public Utilizator(UUID id, String nume, String prenume, String telefon, String id_masina, String email, String parola) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.id_masina = id_masina;
        this.email = email;
        this.parola = parola;
    }

    public UUID getId() {
        return id;
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

    public String getId_masina() {
        return id_masina;
    }

    public String getEmail() {
        return email;
    }

    public String getParola() {
        return parola;
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", id_masina='" + id_masina + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
