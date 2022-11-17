package wsb.java.lecture4.interfaces2;

public class Circle implements Shape {
    private double r;

    public Circle(double r){
        this.r = r;
    }
    public double getArea(){
        return Math.PI * r * r;
    }
    public double getPerimeter(){
        return 2 * Math.PI * r;
    }
}