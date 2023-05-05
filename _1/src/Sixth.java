import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Scanner;
//
//public class Sixth {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int km = sc.nextInt();
//        double l = sc.nextDouble();
//        System.out.printf("%.3f", km / l);
//        System.out.print(" km/l");
//    }
//}
public class Sixth {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int km = Integer.parseInt(bf.readLine());
        double l = Double.parseDouble(bf.readLine());
        System.out.printf("%.3f", km / l);
        System.out.print(" km/l");
    }
}