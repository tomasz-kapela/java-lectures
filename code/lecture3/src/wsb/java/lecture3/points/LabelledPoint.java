package wsb.java.lecture3.points;

public class LabelledPoint {
    private double x = 0;
    private double y = 0;
    private String label = "A";
    public LabelledPoint(String label, double x, double y){
        this.x = x;
        this.y = y;
        this.label = label;
    }
    public void print() {
        System.out.println( label + "(" + x + " ," + y + ")");
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
