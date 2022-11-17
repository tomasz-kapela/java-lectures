public class Variables {
    public static void main(String[] args) {
        //This is comment
        int a = 5;
        long aa;
        var z = 100; //The compiler will try to deduce type. Available since Java 10.
        double b = z * 0.2;
        String c = "Java";
        System.out.println(b);
    }
}