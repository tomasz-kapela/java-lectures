package wsb.java.lecture3.pointsProtected;

public class PointTest {
    public static void main(String[] args) {
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
