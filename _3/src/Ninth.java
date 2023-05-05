import java.util.Scanner;

public class Ninth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int l=sc.nextInt(),c=sc.nextInt();
        // for(int i=1,j=1;i<=l;i++){
        //     for(;j<=l*c;j++){
        //         if(j%4==0)System.out.println("PUM");
        //         else System.out.print(j+" ");
        //     }
        // }
        for(int j=1;j<=l*c;j++){
            if(j%c==0)System.out.println("PUM");
            else System.out.print(j+" ");
        }
    }
}