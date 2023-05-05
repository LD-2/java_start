import java.awt.*;
import java.util.Scanner;

//第一节课讲的是顺序逻辑  一步一步走 一步一步执行
//本节课 加上判断逻辑
public class Test {
    public static void main(String[] args){
        //if-else   else可以省略  一句话大括号可以省略  可以嵌套
        Scanner sc=new Scanner(System.in);
//        int a=sc.nextInt(),b=sc.nextInt();
//        if(a>b)System.out.println(a);
//        else System.out.println(b);

//        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
//        if(a>b)
//            if(a>c)System.out.println(a);
//            else System.out.println(c);
//        else
//            if(c>b)System.out.println(c);
//            else System.out.println(b);


        //常用比较运算符 java中 == 错误了会报错
//        int a=sc.nextInt(),b=sc.nextInt();
//        if(a>b)System.out.printf("%d>%d\n",a,b);
//        if(a>=b)System.out.printf("%d>=%d\n",a,b);
//        if(a<b)System.out.printf("%d<%d\n",a,b);
//        if(a<=b)System.out.printf("%d<=%d\n",a,b);
//        if(a!=b)System.out.printf("%d!=%d\n",a,b);
//        if(a==b)System.out.printf("%d==%d\n",a,b);
        //用小于号可以凑出所有符号 如!(a<b)&&!(b<a)   a<b||b<a

        //if else连写  java中 else if就相当于else中嵌套if else
//        int score=sc.nextInt();
//        if(score>90){
//            System.out.println("A");
//        }
//        else if(score>60){
//            System.out.println("B");
//        }
//        else {
//            System.out.printf("C");
//        }
//        int score=sc.nextInt();
//        if(score>90){
//            System.out.println("A");
//        }
//        else{
//            if(score>60){
//                System.out.println("B");
//            }
//            else{
//                System.out.println("C");
//            }
//        }


//        int x=sc.nextInt();
//        if(x%100==0){
//            if(x%400==0){
//                System.out.println("Yes");
//            }
//            else {
//                System.out.println("No");
//            }
//        }
//        else {
//            if(x%4==0){
//                System.out.println("Yes");
//            }
//            else{
//                System.out.println("No");
//            }
//        }


        //条件符号 || && !
//        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
//        if(a>=b&&a>=c)
//            System.out.println(a);
//        else if(b>=a&&b>=c)
//            System.out.println(b);
//        else System.out.println(c);

//        int x=sc.nextInt();
//        if(x%400==0||x%4==0&&x%100!=0)
//            System.out.println("Yes");
//        else System.out.println("No");


        //switch  case: break;  default:   不写break一个符合执行后就会顺序执行不管对错直到遇到下一个break
        //java中case的作用域已经进行了限定
//        int day=sc.nextInt();
//        switch(day){
//            case 1:
//                System.out.println(1);
//                System.out.println("first");
//                break;
//            case 2:
//                System.out.println(2);
//                int x=250;System.out.println(x);
//                break;
//            case 3:
//                System.out.println(3);
//                break;
//            case 4:
//                System.out.println(4);
//                break;
//                default:
//                    System.out.println("Invalid");
//        }



    }
}
