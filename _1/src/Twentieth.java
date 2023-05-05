import java.util.Scanner;

public class Twentieth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(x / 365 + " ano(s)");
        x %= 365;
        System.out.println(x / 30 + " mes(es)");
        x %= 30;
        System.out.println(x + " dia(s)");
    }
}
