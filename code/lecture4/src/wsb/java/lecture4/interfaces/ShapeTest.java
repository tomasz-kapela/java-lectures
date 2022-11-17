package wsb.java.lecture4.interfaces;

public class ShapeTest {

    public static void main(String[] args) {
//        Shape shape = new Shape();
        Shape[] shapes = { new Circle(10), new Rectangle(2, 4)};
        for(var s: shapes){
            Shape.printInfo(s);
            Shape.printInfo(s);
        }
    }
}
