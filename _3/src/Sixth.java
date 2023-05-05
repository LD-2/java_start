import java.util.Scanner;

public class Sixth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        boolean n=true;
        while (n){
            int x= sc.nextInt();
            if(x==0)break;
            for(int i=1;i<=x;i++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
