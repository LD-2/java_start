import java.util.Scanner;

public class Seventh {
    private static int fact(int n){
        if(n==1)return 1;
        else return fact(n-1)*n;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fact(n));
    }
}
