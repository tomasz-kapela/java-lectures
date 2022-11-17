package wsb.java.lecture3.shapes.inheritance;

public class RightTriangle extends Shape {
    private double a;
    private double b;
    public double computeThirdSide(){
        return Math.sqrt(a * a + b * b);
    }
    public RightTriangle(double a, double b){
        this.a = a;
        this.b = b;
    }
    public double getArea(){
        return (a * b)/2;
    }
    public double getPerimeter(){
        return  a + b + computeThirdSide();
    }
}

