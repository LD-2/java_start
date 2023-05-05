import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Scanner;
//
//public class First {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt(), b = sc.nextInt();
//        System.out.println(a + b);
//    }
//}
public class First {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        System.out.println(Integer.parseInt(strs[0]) + Integer.parseInt(strs[1]));
    }
}