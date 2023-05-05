import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Scanner;
//
//public class Third {
//    public static void main(String[] args) {
//        final double p = 3.14159;
//        Scanner sc = new Scanner(System.in);
//        double R = sc.nextDouble();
//        System.out.printf("A=%.4f", p * R * R);
//    }
//}
public class Third {
    public static void main(String[] args) throws IOException {
        final double P = 3.14159;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        double R = Double.parseDouble(str);
        System.out.printf("A=%.4f", R * R * P);
    }
}