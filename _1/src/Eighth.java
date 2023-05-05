import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//import java.util.Scanner;
//
//public class Eighth {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int money = sc.nextInt();
//        System.out.println(money);
//        System.out.println(money / 100 + " nota(s) de R$ 100,00");
//        money %= 100;
//        System.out.println(money / 50 + " nota(s) de R$ 50,00");
//        money %= 50;
//        System.out.println(money / 20 + " nota(s) de R$ 20,00");
//        money %= 20;
//        System.out.println(money / 10 + " nota(s) de R$ 10,00");
//        money %= 10;
//        System.out.println(money / 5 + " nota(s) de R$ 5,00");
//        money %= 5;
//        System.out.println(money / 2 + " nota(s) de R$ 2,00");
//        money %= 2;
//        System.out.println(money + " nota(s) de R$ 1,00");
//    }
//}
public class Eighth {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        wr.write(money + "\n");
        wr.flush();
        wr.write(money / 100 + " nota(s) de R$ 100,00\n");
        wr.flush();
        money %= 100;
        wr.write(money / 50 + " nota(s) de R$ 50,00\n");
        wr.flush();
        money %= 50;
        wr.write(money / 20 + " nota(s) de R$ 20,00\n");
        wr.flush();
        money %= 20;
        wr.write(money / 10 + " nota(s) de R$ 10,00\n");
        wr.flush();
        money %= 10;
        wr.write(money / 5 + " nota(s) de R$ 5,00\n");
        wr.flush();
        money %= 5;
        wr.write(money / 2 + " nota(s) de R$ 2,00\n");
        wr.flush();
        money %= 2;
        wr.write(money + " nota(s) de R$ 1,00\n");
        wr.flush();
    }
}