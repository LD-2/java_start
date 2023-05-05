import java.util.Scanner;

public class Eighteenth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.printf("%.3f", (double) a * b / 12);
    }
}
