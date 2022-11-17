package wsb.java.lecture4.interfaces;

public interface Shape{
    double getArea();
    double getPerimeter();

    static void printInfo(Shape shape){
        System.out.println("Area : " + shape.getArea() + " Perimeter : " + shape.getPerimeter());
    }
}