package ro.siit.model;

public class Coordonate {
    private String numeFirma;
    private String nume;
    private String nrInmatriculare;
    private String latitudine;
    private String longitudine;

    public Coordonate(String numeFirma, String nume, String nrInmatriculare, String latitudine, String longitudine) {
        this.numeFirma = numeFirma;
        this.nume = nume;
        this.nrInmatriculare = nrInmatriculare;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public String getNumeFirma() {
        return numeFirma;
    }

    public String getNume() {
        return nume;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public String getLatitudine() {
        return latitudine;
    }

    public String getLongitudine() {
        return longitudine;
    }

    @Override
    public String toString() {
        return "Coordonate{" +
                "nume='" + nume + '\'' +
                ", nrInmatriculare='" + nrInmatriculare + '\'' +
                ", latitudine='" + latitudine + '\'' +
                ", longitudine='" + longitudine + '\'' +
                '}';
    }
}
