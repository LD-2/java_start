import java.util.Scanner;

public class Twelfth {
    public static void main(String[] args) {
        final double fixed = 3.14159;
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        System.out.printf("VOLUME = %.3f", 4 / 3.0 * fixed * R * R * R);
    }
}
