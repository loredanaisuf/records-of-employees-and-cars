package ro.siit.model;

public class Remorca {
    private String nrInmatriculareRemorca;
    private String firma;
    private String nrInmatriculareMasina;
    private Integer anulFabricatiei;
    private String itp;
    private String asigurare;

    public Remorca(String nrInmatriculareRemorca, String firma, String nrInmatriculareMasina, Integer anulFabricatiei, String itp, String asigurare) {
        this.nrInmatriculareRemorca = nrInmatriculareRemorca;
        this.firma = firma;
        this.nrInmatriculareMasina = nrInmatriculareMasina;
        this.anulFabricatiei = anulFabricatiei;
        this.itp = itp;
        this.asigurare = asigurare;
    }

    public String getNrInmatriculareRemorca() {
        return nrInmatriculareRemorca;
    }

    public String getFirma(){ return firma;}

    public String getNrInmatriculareMasina() {
        return nrInmatriculareMasina;
    }

    public Integer getAnulFabricatiei() {
        return anulFabricatiei;
    }

    public String getItp() {
        return itp;
    }

    public String getAsigurare(){ return asigurare; }
}
