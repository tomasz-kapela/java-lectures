public class RegularExpressions {

    public static void main(String[] args) {
        String s1 = "Hello2";

        System.out.println(s1.matches("[A-Za-z]+[0-9]"));

        String s2 = "He llo 2";
        for (String s: s2.split(" "))
            System.out.println(s);

    }
}
