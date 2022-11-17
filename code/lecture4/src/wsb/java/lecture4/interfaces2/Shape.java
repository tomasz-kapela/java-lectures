package wsb.java.lecture4.interfaces2;

public interface Shape{
    double getArea();
    double getPerimeter();
    // We extend interface.
    // Without the implementation it will destroy the legacy code.
    default String getName () {
        return "?";
    }
    static void printInfo(Shape shape){
        System.out.println("Name : "+ shape.getName()
                + "Area : " + shape.getArea()
                + " Perimeter : " + shape.getPerimeter());
    }
}