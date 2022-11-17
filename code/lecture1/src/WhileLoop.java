public class WhileLoop {

    public static void main(String[] args) {
        int a = 5;
        int result = 1;
        int i = 1;
        while (i <= a){
            result *= i;
            i++;
        }
        System.out.println(a + "!=" + result);
    }
}
