public class StringEquality2 {
    public static void main(String[] args) {
        String s1 = "Hello"; //creating string as a literal
        String s2 = "Hello";
        String s3 = new String("Hello");
        if (s1.equals(s2)){
            System.out.println("s1 and s2 are equal");
        } else {
            System.out.println("s1 and s2 are not equal");
        }
        if (s2.equals(s3)){
            System.out.println("s2 and s3 are equal");
        } else {
            System.out.println("s2 and s3 are not equal");
        }
    }
}
