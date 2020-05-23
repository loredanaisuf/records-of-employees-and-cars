package ro.siit.model;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.UUID;

public class InformatiiMasina {
    private UUID id;
    private String numarInmariculare;
    private String data;
    private Float numarKm;
    private Integer cantitate;
    private Float consum;

    public InformatiiMasina(UUID id, String numarInmariculare, String data, Float numarKm, Integer cantitate, Float consum) {
        this.id = id;
        this.numarInmariculare = numarInmariculare;
        this.data = data;
        this.numarKm = numarKm;
        this.cantitate = cantitate;
        this.consum = consum;
    }

    public UUID getId() {
        return id;
    }

    public String getNumarInmariculare() {
        return numarInmariculare;
    }

    public String getData() {
        return data;
    }

    public Float getNumarKm() {
        return numarKm;
    }

    public Integer getCantitate() {
        return cantitate;
    }

    public Float getConsum() {
        return consum;
    }


}
