import java.util.Scanner;

public class Third {
    private static int gcd(int a,int b){
        return a%b==0?b:gcd(b,a%b);
//        return b ? gcd(b, a % b) : a; java中只有boolean类型的
    }
    public static void main(String[] args){
        Scanner sc=new Scanner( System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        System.out.println(gcd(a,b));
    }
}