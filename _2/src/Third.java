import java.util.Scanner;

public class Third {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double x=sc.nextDouble();
        if(x>=0&&x<=25){
            System.out.println("Intervalo [0,25]");
        }
        else if(x<=50&&x>0){
            System.out.println("Intervalo (25,50]");
        }
        else if(x<=75&&x>0){
            System.out.println("Intervalo (50,75]");
        }
        else if(x<=100&&x>0){
            System.out.println("Intervalo (75,100]");
        }
        else {
            System.out.println("Fora de intervalo");
        }
    }
}
