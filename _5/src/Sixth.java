import java.util.Scanner;

public class Sixth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.next(), str2 = sc.next();
            char c = str1.charAt(0);
            for (int i = 1; i < str1.length(); i++) {
                if (c < str1.charAt(i)) c = str1.charAt(i);
            }
            String s1 = str1.substring(0, str1.indexOf(c) + 1);
            String s2 = str1.substring(str1.indexOf(c) + 1);
            System.out.println(s1 + str2 + s2);
        }
    }
}
