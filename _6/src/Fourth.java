import java.util.Scanner;

public class Fourth {
    private static void swap(int[] a){
        int t=a[0];
        a[0]=a[1];
        a[1]=t;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt(),y=sc.nextInt();
        int[] a={x,y};
        swap(a);
        for(int res:a)System.out.print(res+" ");
    }
}

