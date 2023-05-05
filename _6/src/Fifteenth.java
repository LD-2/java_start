import java.util.Scanner;

public class Fifteenth {
    private static void reverse(int[] a,int size) {
        for (int i = 0,j = size-1; i<j;i++,j--) {
            int t=a[i];
            a[i]=a[j];
            a[j]=t;
        }
        for (int x:a)System.out.print(x+" ");
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),size=sc.nextInt();
        int[] a= new int[n];
        for (int i=0;i<n;i++)a[i]=sc.nextInt();
        reverse(a,size);
    }
}
