import java.util.Scanner;

public class Twentieth {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble(),b=sc.nextDouble(),c=sc.nextDouble();
        if(a<b){
            double t=a;
            a=b;
            b=t;
        }
        if(a<c){
            double t=a;
            a=c;
            c=t;
        }
        if(b<c){
            double t=b;
            b=c;
            c=t;
        }
        if (a >= b + c)
            System.out.println("NAO FORMA TRIANGULO");
        else {
            if (a * a == b * b + c * c)
                System.out.println("TRIANGULO RETANGULO");
            if (a * a > b * b + c * c)
                System.out.println("TRIANGULO OBTUSANGULO");
            if (a * a < b * b + c * c)
                System.out.println("TRIANGULO ACUTANGULO");
            if (a == b && b == c)
                System.out.println("TRIANGULO EQUILATERO");
            else if (a == b || b == c || c == a)
                System.out.println("TRIANGULO ISOSCELES");
        }

    }
}
