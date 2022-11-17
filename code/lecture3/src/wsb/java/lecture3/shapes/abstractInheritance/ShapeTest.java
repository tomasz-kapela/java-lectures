package wsb.java.lecture3.shapes.abstractInheritance;

// 1st option: Subclass implements all abstract methods
class MyPoint extends Shape{

    public double getArea() {
        return 0;
    }
    public double getPerimeter() {
        return 0;
    }
}
// 2nd option: Subclass has to be abstract if at least one abstract method do not have implementation
abstract  class MyShape extends Shape{
    public double getPerimeter() {
        return 0;
    }
}

public class ShapeTest {
    private static void prettyPrint(Shape shape){
        System.out.println("Perimeter is: " + Math.round(shape.getPerimeter()*10)/10.0);
        System.out.println("Area is: " + Math.round(shape.getArea()*10)/10.0);
    }

    public static void main(String[] args) {

        // ERROR: Can not create instance of an abstract class!
        // Shape shape = new Shape();

        Shape s = new MyPoint();

        Shape shapes[] ={
                new Circle(5), new Rectangle(2,4),
                new RightTriangle(3,4),
                new Circle(3)};

        for(Shape shape: shapes) {
            prettyPrint(shape);
            if(shape instanceof RightTriangle){
                ((RightTriangle)shape).computeThirdSide();
            }
        }
    }
}
