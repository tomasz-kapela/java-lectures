public class Incrementation3 {
    public static void main(String[] args) {
        int a = 5;
        int b = a++ + 5;
        int c = --b - a++;
        System.out.println(c);
    }
}
