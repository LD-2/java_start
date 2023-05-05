import java.util.Scanner;

public class Seventeenth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double L = sc.nextDouble();
        System.out.printf("%.0f", L / 30 * 60);
        System.out.println(" minutos");
    }
}
