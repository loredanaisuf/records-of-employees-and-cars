package ro.siit.model;

public class InformatiiPtGrafic {
    private String x;
    private String y;

    public InformatiiPtGrafic(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    @Override
    public String toString() {
        return "InformatiiPtGrafic{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }
}
