package wsb.java.lecture3.pointsCasting;

public class PointTest {
    public static void main(String[] args) {

        LabelledPoint c = new LabelledPoint("C", 0 ,0);

        // Implicit casting
        Point p = c;
        Object o = c;

        p.getX();
        // p.getLabel(); // Compilation ERROR!

        // LabelledPoint l = p; // Compilation ERROR!

        // Explicit casting
        LabelledPoint l2 = (LabelledPoint) p;
        l2.getLabel();

        Point p3 = new Point(0., 0.);
        // LabelledPoint l3 = (LabelledPoint) p3; // Run-time error

        // We can check if p refers to and object of type LabelledPoint (or its subclass)
        if(p instanceof LabelledPoint) {
            LabelledPoint l4 = (LabelledPoint) p;
            System.out.println(l4.getLabel());
        }

        Point points[] = {
                new Point(1.0, 3.0),
                new LabelledPoint("B", 1, 4),
                new Point(6, 3)
        };

        for(Point point: points) {
            point.print();
        }
    }
}
