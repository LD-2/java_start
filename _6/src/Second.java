import java.util.Scanner;

public class Second {
    private static int max(int a,int b){
        if(a>b)return a;
        else return b;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        System.out.println(max(a,b));
    }
}
