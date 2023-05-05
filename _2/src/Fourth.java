import java.util.Scanner;

public class Fourth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble(),b=sc.nextDouble(),c=sc.nextDouble();
        if(a+b>c&&a+c>b&&b+c>a){
            System.out.printf("Perimetro = %.1f",a+b+c);

        }
        else {
            System.out.printf("Area = %.1f",(a+b)*c/2);
        }
    }
}
