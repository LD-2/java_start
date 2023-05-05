import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //数据类型  以及计算机原理  计算机中 数据的存储形式 补码运算 存储  浮点类型单双 默认双精度
        int a = 1, b = 2, c = 3, d = 4;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        //显性表示
        float e = 3.1f;
        float f = 3.2F;
        System.out.println(e);
        System.out.println(f);
        //强制类型转换  显示转换 隐式转换将范围小的转换为范围大的
        System.out.println((int) 3.20);
        System.out.println((int) '1');
        System.out.println(3 + 'b');
        //变量常量
        int g = 7;
        g = 9;
        System.out.println(g);
        final int h = 6;
        System.out.println(h);
        //运算符  java和c++是向0取整  python是向下取整
        int i = -30, j = 20;
        System.out.println(i / j);
        System.out.println(i % j);
        int k = 1;
        System.out.println(k++ + " " + k);
        System.out.println(++k + " " + k);
        System.out.println(k += 2);
        System.out.println(k = 0);
        double l = 2.2, m = 3.3;
        System.out.println(l / m);
        float ll = 2.2f, mm = 3.3f;
        System.out.println(ll / mm);
        //浮点数的比较
        double x = 1, y = 2;
        if (Math.abs(x - y) < 1e-8) {
            System.out.println("Yes");
        }
        //输入方式1 慢的输入方式 1e5内
//        System.out.println("请输入：");
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();//next识别字符串的时候遇到空格回车指标符结束读入
//        System.out.println(str);
//        str = sc.next();//next识别字符串的时候遇到空格回车指标符结束读入
//        System.out.println(str);
//        System.out.println("请输入：");

//        String str2 = sc.nextLine();//读入一行数据
//        System.out.println(str2);

//        int aa = sc.nextInt(), bb = sc.nextInt();
//        System.out.print(aa + bb);
//        float aaa = sc.nextFloat(), bbb = sc.nextFloat();
//        System.out.println(aaa + bbb);
        //输入方式2
//        System.out.println("请输入：");
//        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        String str = buff.readLine();
//        System.out.println(str);


        //readline读入整数的方式

//        System.out.println("请输入：");
//        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        int o = Integer.parseInt(buff.readLine());
//        int p = Integer.parseInt(buff.readLine());
//        System.out.println(o + p);

//        System.out.println("请输入：");
//        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        String[] strs = buff.readLine().split(" ");
//        int o = Integer.parseInt(strs[0]);
//        int p = Integer.parseInt(strs[1]);
//        System.out.println(o + p);

        //输出 方式1：  %-04d 不可以
        System.out.print(33 + "  ");
        System.out.println(2);
        System.out.printf("%4d-%02d-%02d  %.2f\n", 2022, 9, 14, 3.12556);//double和float都是f
        System.out.printf("%4d-%4d-%4d\n", 2022, 9, 14);
        System.out.printf("%-4d-%-4d-%-4d\n", 2022, 9, 14);
//
//        //输出 方式2：
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        bw.write("mirror");
//        bw.flush();
    }
}
