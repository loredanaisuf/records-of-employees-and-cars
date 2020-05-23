package ro.siit.model;

import java.util.UUID;

public class Pontaj {
    private UUID idAngajat;
    private String numePrenume;
    private String data;
    private int numarOre;

    public Pontaj(UUID idAngajat, String numePrenume, String data, int numarOre) {
        this.idAngajat = idAngajat;
        this.numePrenume = numePrenume;
        this.data = data;
        this.numarOre = numarOre;
    }

    public UUID getIdAngajat() {
        return idAngajat;
    }

    public String getNumePrenume() {
        return numePrenume;
    }

    public String getData() {
        return data;
    }

    public int getNumarOre() {
        return numarOre;
    }

    @Override
    public String toString() {
        return "Pontaj{" +
                "idAngajat=" + idAngajat +
                ", numePrenume='" + numePrenume + '\'' +
                ", data='" + data + '\'' +
                ", numarOre=" + numarOre +
                '}';
    }
}
