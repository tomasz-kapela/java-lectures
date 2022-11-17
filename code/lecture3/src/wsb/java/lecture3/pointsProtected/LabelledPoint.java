package wsb.java.lecture3.pointsProtected;

public class LabelledPoint extends Point {
    private String label = "A";

    public LabelledPoint(double x, double y){
       super(x,y);
    }
    public LabelledPoint(String label, double x, double y){
       super(x,y);
       // this.x = x;
       this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public void print() {
        System.out.println( label + "(" + x + " ," + y + ")");
    }

}
