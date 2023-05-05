import java.util.Scanner;

public class Nineteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while (n-->0){
            int x=sc.nextInt();
            boolean isP=true;
            for(int i=2;i<=x/i;i++){
                if(x%i==0)isP=false;
            }
            if(isP)System.out.println(x+" is prime");
            else System.out.println(x+" is not prime");
        }
    }
}
