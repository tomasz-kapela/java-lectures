public class BreakTwo {
    public static void main(String[] args) {
        for (int j = 0; j < 4; j++){
            System.out.print("j=" + j + " ");
            for (int i = 0; i < 3; i++){
                System.out.print("i=" + i + " ");
                if (i == 1)
                    break;
            }
            System.out.println();
        }
    }
}
