import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Scanner;
//
//public class Fourth {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double A = sc.nextDouble(), B = sc.nextDouble();
//        System.out.printf("MEDIA = %.5f", (A * 3.5 + B * 7.5) / 11);
//    }
//}
public class Fourth {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double A = Double.parseDouble(bf.readLine());
        double B = Double.parseDouble(bf.readLine());
        System.out.printf("MEDIA = %.5f", (A * 3.5 + B * 7.5) / 11);
    }
}