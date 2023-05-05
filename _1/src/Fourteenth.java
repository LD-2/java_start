import java.util.Scanner;

public class Fourteenth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        System.out.printf("MEDIA = %.1f", a * 2 / 10 + b * 3 / 10 + c * 5 / 10);
    }
}
