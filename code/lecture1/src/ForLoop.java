public class ForLoop {
    public static void main(String[] args) {
        int a = 5;
        int result = 1;
        for (int i = 1; i <= a; i++){
            result *= i;
        }
        System.out.println(a + "!=" + result);
    }
}
