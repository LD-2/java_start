import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Scanner;
//
//public class Fifth {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String num = sc.next();
//        int time = sc.nextInt();
//        double salary = sc.nextDouble();
//        System.out.println("NUMBER = " + num);
//        System.out.printf("SALARY = U$ %.2f", salary * time);
//    }
//}
public class Fifth {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int time = Integer.parseInt(bf.readLine());
        double salary = Double.parseDouble(bf.readLine());
        System.out.printf("NUMBER = %d\nSALARY = U$ %.2f", num, salary * time);
    }
}