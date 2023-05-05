import java.util.Scanner;

public class Tenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] a=new int[20];
        for (int i=19;i>=0;i--){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<20;i++){
            System.out.println("N["+i+"] = "+a[i]);
        }
    }
}
