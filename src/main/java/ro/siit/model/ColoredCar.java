package ro.siit.model;

public class ColoredCar {
    private String numarInmatriculare;
    private int index;
    private boolean selectat;

    public ColoredCar(String numarInmatriculare, int index, boolean selectat) {
        this.numarInmatriculare = numarInmatriculare;
        this.index = index;
        this.selectat = selectat;
    }

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public int  getIndex() {
        return index;
    }

    public boolean isSelectat() {
        return selectat;
    }

    public void setSelectat(boolean selectat) {
        this.selectat = selectat;
    }

    @Override
    public String toString() {
        return "ColoredCar{" +
                "nrInmatriculare='" + numarInmatriculare + '\'' +
                ", color='" + index + '\'' +
                ", value='" + selectat + '\'' +
                '}';
    }
}
