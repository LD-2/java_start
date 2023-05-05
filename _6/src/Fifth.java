import java.util.Arrays;
import java.util.Scanner;

public class Fifth {
    private static void print(int[] a,int size){
        int cnt=0;
        for(int x:a){
            if(cnt++ == size)return;
            System.out.print(x+" ");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int l=sc.nextInt(),i=sc.nextInt();
        int[] a=new int[l];
        for(int j=0;j<l;j++)a[j]=sc.nextInt();
        print(a,i);
    }
}
