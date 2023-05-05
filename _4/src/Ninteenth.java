import java.util.Scanner;

public class Ninteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (true){
            int x=sc.nextInt();
            if(x==0)break;
            for(int i=0;i<x;i++) {
                for (int j = 0; j < x; j++) {
                    System.out.print((int)Math.pow(2,(j+i))+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
