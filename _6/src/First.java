import java.util.Scanner;

public class First {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fact(n));
    }
    private static int fact(int n){
        int res=1;
        for(int i=1;i<=n;i++)res*=i;
        return res;
    }
}
