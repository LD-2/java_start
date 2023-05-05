import java.util.Scanner;

public class Eighth {
    private static int f(int n){
        if(n<=2)return 1;
        else return f(n-1)+f(n-2);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(f(n));
    }
}
