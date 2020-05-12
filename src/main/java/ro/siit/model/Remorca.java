package ro.siit.model;

public class Remorca {
    private String nrInmatriculareRemorca;
    private String nrInmatriculareMasina;
    private Integer anulFabricatiei;
    private String itp;

    public Remorca(String nrInmatriculareRemorca, String nrInmatriculareMasina, Integer anulFabricatiei, String itp) {
        this.nrInmatriculareRemorca = nrInmatriculareRemorca;
        this.nrInmatriculareMasina = nrInmatriculareMasina;
        this.anulFabricatiei = anulFabricatiei;
        this.itp = itp;
    }

    public String getNrInmatriculareRemorca() {
        return nrInmatriculareRemorca;
    }

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
