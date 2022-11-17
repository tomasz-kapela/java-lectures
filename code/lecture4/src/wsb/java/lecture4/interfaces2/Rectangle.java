package wsb.java.lecture4.interfaces2;

public class Rectangle implements Shape {
    protected double a = 0.0;
    protected double b = 0.0;

    public Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return a*b;
    }

    @Override
    public double getPerimeter() {
        return 2*(a+b);
    }
}
