import java.util.Scanner;

public class Second {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int[] a=new int[10];
        a[0]=v;
        for (int i=1; i<10;i++){
            a[i]=a[i-1]*2;
        }
        for (int i=0; i<10; i++){
            System.out.println("N["+i+"] = "+a[i]);
        }
    }
}
