package wsb.java.lecture3.pointsProtected;

public class Point {
    protected double x = 0;
    protected double y = 0;

    public Point(double x, double y){
       this.x = x;
       this.y = y;
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

    public void print() {
        System.out.println("(" + x + " ," + y + ")");
    }


}
