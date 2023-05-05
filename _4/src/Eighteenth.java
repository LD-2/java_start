import java.util.Scanner;

public class Eighteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (true){
            int x=sc.nextInt();
            if(x==0)break;
            for(int i=0;i<x;i++) {
                for (int j = 0; j < x; j++) {
                    if(i<j) System.out.print(j - i + 1 + " ");
                    else System.out.print(i-j+1+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
