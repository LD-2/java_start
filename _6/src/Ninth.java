import java.util.Scanner;

public class Ninth {
    private static int abs(int x){
        if(x>0)return x;
        else if(x<0)return -x;
        else return 0;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        System.out.println(abs(x));
    }
}
