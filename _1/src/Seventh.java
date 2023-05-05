import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Scanner;
//
//public class Seventh {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double x1 = sc.nextDouble(), y1 = sc.nextDouble(), x2 = sc.nextDouble(), y2 = sc.nextDouble();
//        double dx = x2 - x1, dy = y2 - y1;
//        double result = Math.sqrt(dy * dy + dx * dx);
//        System.out.printf("%.4f", result);
//    }
//}
public class Seventh {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bf.readLine(), str2 = bf.readLine();
        String[] strA = str1.split(" "), strB = str2.split(" ");
        double x1 = Double.parseDouble(strA[0]), y1 = Double.parseDouble(strA[1]);
        double x2 = Double.parseDouble(strB[0]), y2 = Double.parseDouble(strB[1]);
        double dx = x2 - x1, dy = y2 - y1;
        double result = Math.sqrt(dy * dy + dx * dx);
        System.out.printf("%.4f", result);
    }
}