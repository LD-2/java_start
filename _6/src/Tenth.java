import java.util.Scanner;

public class Tenth {
    private static double add(double a,double b){
        return a+b;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble(),b=sc.nextDouble();
        System.out.printf("%.2f",add(a,b));
    }
}
