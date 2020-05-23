package ro.siit.model;

public class Remorca {
    private String nrInmatriculareRemorca;
    private String firma;
    private String nrInmatriculareMasina;
    private Integer anulFabricatiei;
    private String itp;

    public Remorca(String nrInmatriculareRemorca, String firma, String nrInmatriculareMasina, Integer anulFabricatiei, String itp) {
        this.nrInmatriculareRemorca = nrInmatriculareRemorca;
        this.firma = firma;
        this.nrInmatriculareMasina = nrInmatriculareMasina;
        this.anulFabricatiei = anulFabricatiei;
        this.itp = itp;
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
}
