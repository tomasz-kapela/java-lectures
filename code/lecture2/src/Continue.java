public class Continue {
    public static void main(String[] args) {
        for (int i = 4; i < 10; i++){
            System.out.print(i);
            if (i >= 5 && i <= 7)
                continue;
            System.out.print("E");
        }
    }
}
