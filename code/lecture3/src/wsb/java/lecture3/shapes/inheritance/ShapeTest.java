package wsb.java.lecture3.shapes.inheritance;


public class ShapeTest {
    private static void prettyPrint(Shape shape){
        System.out.println("Perimeter is: " + Math.round(shape.getPerimeter()*10)/10.0);
        System.out.println("Area is: " + Math.round(shape.getArea()*10)/10.0);
    }

    public static void main(String[] args) {
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
