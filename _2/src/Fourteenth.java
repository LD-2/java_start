import java.util.Scanner;

public class Fourteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
        if(a>b){
            if(a>c){
                if(b>c){
                    System.out.println(c);
                    System.out.println(b);
                    System.out.println(a);
                }
                else{
                    System.out.println(b);
                    System.out.println(c);
                    System.out.println(a);
                }
            }
            else {
                System.out.println(b);
                System.out.println(a);
                System.out.println(c);
            }
        }//a<b
        else {
            if(b>c){
                if(c>a){
                    System.out.println(a);
                    System.out.println(c);
                    System.out.println(b);
                }
                else {
                    System.out.println(c);
                    System.out.println(a);
                    System.out.println(b);
                }
            }
            else{
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
            }
        }
        System.out.println();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
