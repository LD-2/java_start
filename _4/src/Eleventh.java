import java.util.Scanner;

public class Eleventh{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long[] f=new long[61];
        int n=sc.nextInt();
        while (n-->0){
            int x=sc.nextInt();

            f[0]=0;f[1]=1;
            for(int i=2;i<=x;i++){
                f[i]=f[i-1]+f[i-2];
            }
            System.out.println("Fib("+x+")" +" = "+f[x]);
        }
    }
}
