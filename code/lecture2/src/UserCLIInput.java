import java.io.IOException;

public class UserCLIInput {
    public static void main(String[] args) throws IOException {
        int a = System.in.read();
        System.out.println(a);
        System.out.println((char) a);
    }
}
