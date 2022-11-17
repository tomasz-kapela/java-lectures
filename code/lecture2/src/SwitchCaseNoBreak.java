public class SwitchCaseNoBreak {
    public static void main(String[] args) {
        int day=7;
        switch (day){
            case 6:
                System.out.println("It's Saturday");
                break;
            case 7:
                System.out.println("It's Sunday");
            default:
                System.out.println("It's working day");
        }

    }
}
