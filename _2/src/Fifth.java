import java.util.Scanner;

public class Fifth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        if(a==b){
            System.out.println("O JOGO DUROU 24 HORA(S)");
        }
        else if(a<b){
            System.out.printf("O JOGO DUROU %d HORA(S)\n",b-a);
        }
        else {
            System.out.printf("O JOGO DUROU %d HORA(S)\n",24-a+b);
        }
    }
}
