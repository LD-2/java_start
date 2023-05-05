import java.util.Scanner;

public class Fifteenth {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble(),b=sc.nextDouble(),c=sc.nextDouble();
        if(b*b-4*a*c<0||a==0)System.out.println("Impossivel calcular");
        else{
            double x1=(-b+Math.sqrt(b*b-4*a*c))/2/a;
            double x2=(-b-Math.sqrt(b*b-4*a*c))/2/a;
            System.out.printf("R1 = %.5f\n",x1);
            System.out.printf("R2 = %.5f\n",x2);
        }
    }
}
