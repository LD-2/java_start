import java.util.Scanner;

public class Twelfth {
    private static int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    private static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        System.out.println(lcm(a,b));
    }
}
