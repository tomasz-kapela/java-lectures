package wsb.java.lecture3.points2;

public class LabelledPoint extends Point {
    private String label = "A";

    public LabelledPoint(String label, double x, double y){
       super(x,y);   // Calls constructor of a base class
       this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public void print() {
        System.out.println( label + "(" + getX() + " ," + getY() + ")");
    }

    public void printSuper() {
        System.out.print( label) ;
        super.print();
    }
}
