package ro.siit.model;

public class Masina {
    private String nrInmatriculare;
    private String firma;
    private String marca;
    private Integer anulFabricatiei;
    private String itp = "05/21/2020";
    private String rca = "05/21/2020";
    private String casco = "05/21/2020";
    private String rovignieta = "05/21/2020";

    public Masina(String nrInmatriculare, String firma, String marca, Integer anulFabricatiei, String itp, String rca, String casco, String rovignieta) {
        this.nrInmatriculare = nrInmatriculare;
        this.firma = firma;
        this.marca = marca;
        this.anulFabricatiei = anulFabricatiei;
        this.itp = itp;
        this.rca = rca;
        this.casco = casco;
        this.rovignieta = rovignieta;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public String getFirma(){ return firma;}

    public String getMarca() {
        return marca;
    }

    public Integer getAnulFabricatiei() {
        return anulFabricatiei;
    }

    public String getItp() {
        return itp;
    }

    public String getRca() {
        return rca;
    }

    public String getCasco() {
        return casco;
    }

    public String getRovignieta() {
        return rovignieta;
    }
}
