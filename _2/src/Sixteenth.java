import java.util.Scanner;

public class Sixteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble(),b=sc.nextDouble(),c=sc.nextDouble(),d=sc.nextDouble();
        double ave=(a*2+b*3+c*4+d)/10;
        System.out.printf("Media: %.1f\n",ave);
        if(ave>=7)System.out.println("Aluno aprovado.");
        else if(ave<5)System.out.println("Aluno reprovado.");
        else{
            System.out.println("Aluno em exame.");
            double y=sc.nextDouble();
            System.out.printf("Nota do exame: %.1f\n",y);
            double finalave=(ave+y)/2;
            if(finalave>=5)System.out.printf("Aluno aprovado.\n");
            else System.out.printf("Aluno reprovado.\n");
            System.out.printf("Media final: %.1f",finalave);
        }
    }
}
