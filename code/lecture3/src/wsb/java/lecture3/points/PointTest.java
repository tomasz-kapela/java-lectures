package wsb.java.lecture3.points;

public class PointTest {
    public static void main(String[] args) {
        Point A = new Point(1.0, 3.0);
        LabelledPoint B = new LabelledPoint("B", 1, 4);
        A.print();
        B.print();
    }
}
