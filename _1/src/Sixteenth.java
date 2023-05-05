import java.util.Scanner;

public class Sixteenth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
        int first = Math.max(a, b), second = Math.max(first, c);
        System.out.println(second + " eh o maior");
    }
}
