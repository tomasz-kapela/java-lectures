package wsb.java.lecture3.shapes;

public class ShapeTest {


    private static void prettyPrint(Circle shape){
        System.out.println("Perimeter is: " + Math.round(shape.getPerimeter()*10)/10.0);
        System.out.println("Area is: " + Math.round(shape.getArea()*10)/10.0);
    }

    private static void prettyPrint(Rectangle shape){
        System.out.println("Perimeter is: " + Math.round(shape.getPerimeter()*10)/10.0);
        System.out.println("Area is: " + Math.round(shape.getArea()*10)/10.0);
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(2,4);
        prettyPrint(circle);
        prettyPrint(rectangle);
    }

}
