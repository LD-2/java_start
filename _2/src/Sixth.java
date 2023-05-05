import java.util.Scanner;

public class Sixth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double x=sc.nextDouble();
        if(x>=0&&x<=400){
            System.out.printf("Novo salario: %.2f\n",x*(0.15+1));
            System.out.printf("Reajuste ganho: %.2f\n",x*0.15);
            System.out.print("Em percentual: "+15+" %\n");
        }
        else if(x>0&&x<=800){
            System.out.printf("Novo salario: %.2f\n",x*(0.12+1));
            System.out.printf("Reajuste ganho: %.2f\n",x*0.12);
            System.out.print("Em percentual: "+12+" %\n");
        }
        else if(x>0&&x<=1200){
            System.out.printf("Novo salario: %.2f\n",x*(0.10+1));
            System.out.printf("Reajuste ganho: %.2f\n",x*0.10);
            System.out.print("Em percentual: "+10+" %\n");
        }
        else if(x>0&&x<=2000){
            System.out.printf("Novo salario: %.2f\n",x*(0.07+1));
            System.out.printf("Reajuste ganho: %.2f\n",x*0.07);
            System.out.print("Em percentual: "+7+" %\n");
        }
        else{
            System.out.printf("Novo salario: %.2f\n",x*(0.04+1));
            System.out.printf("Reajuste ganho: %.2f\n",x*0.04);
            System.out.print("Em percentual: "+4+" %\n");
        }
    }
}
