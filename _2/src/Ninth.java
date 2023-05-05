import java.util.Scanner;

public class Ninth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();String res="";
        switch(x) {
            case 61:
                res = "Brasilia";
                break;
            case 71:
                res = "Salvador";
                break;
            case 11:
                res = "Sao Paulo";
                break;
            case 21:
                res = "Rio de Janeiro";
                break;
            case 32:
                res = "Juiz de Fora";
                break;
            case 19:
                res = "Campinas";
                break;
            case 27:
                res = "Vitoria";
                break;
            case 31:
                res = "Belo Horizonte";
                break;
            default:
                res = "DDD nao cadastrado";
        }
        System.out.println(res);
    }
}
