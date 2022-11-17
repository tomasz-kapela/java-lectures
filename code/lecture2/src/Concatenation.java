public class Concatenation {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello2";
        String s3 = s1 + s2; //or s1.concat(s2)
        System.out.println(s3 == "HelloHello2");
        System.out.println(s3.equals("HelloHello2"));
    }
}
