import java.util.Scanner;  // Import the Scanner class

public class UserCLIInputScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username");

        String userName = scanner.next();
        System.out.println("Username is: " + userName);
    }

}
