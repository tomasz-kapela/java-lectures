public class Arrays {
    public static void main(String[] args) {
        //Declaration of an array
        int[] a;
        int b[];
        //Initialization of an array
        a = new int[5];
        b = new int[]{1, 2, 3}; // array literal
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
