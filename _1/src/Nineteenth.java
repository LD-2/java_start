//取余除了布尔类型都可以
//这个printf  .f只能浮点型 严格遵循c语言格式
//java中double存0.1  存近似值有效数字8-9位

import java.io.*;

public class Nineteenth {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double money = Double.parseDouble(bf.readLine());
        // System.out.println(money);
        int m = (int) money;
        money -= m;
        // System.out.println(m);
        // System.out.println(money);
        money += 1e-8;
        // System.out.println(money);
        System.out.println("NOTAS:");
        System.out.print(m / 100);
        System.out.print(" nota(s) de R$ 100.00\n");
        m %= 100;
        System.out.print(m / 50);
        System.out.print(" nota(s) de R$ 50.00\n");
        m %= 50;
        System.out.print(m / 20);
        System.out.print(" nota(s) de R$ 20.00\n");
        m %= 20;
        System.out.print(m / 10);
        System.out.print(" nota(s) de R$ 10.00\n");
        m %= 10;
        System.out.print(m / 5);
        System.out.print(" nota(s) de R$ 5.00\n");
        m %= 5;
        System.out.print(m / 2);
        System.out.print(" nota(s) de R$ 2.00\n");
        m %= 2;


        System.out.println("MOEDAS:");
        System.out.print(m / 1);
        System.out.print(" moeda(s) de R$ 1.00\n");
        money %= 1;
        System.out.print((int) (money / 0.5));
        System.out.print(" moeda(s) de R$ 0.50\n");
        money %= 0.5;
        System.out.print((int) (money / 0.25));
        System.out.print(" moeda(s) de R$ 0.25\n");
        money %= 0.25;
        System.out.print((int) (money / 0.1));
        System.out.print(" moeda(s) de R$ 0.10\n");
        money %= 0.1;
        System.out.print((int) (money / 0.05));
        System.out.print(" moeda(s) de R$ 0.05\n");
        money %= 0.05;
        System.out.print((int) (money / 0.01));
        System.out.print(" moeda(s) de R$ 0.01\n");
        money %= 0.01;
    }
}
