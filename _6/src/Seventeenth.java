import java.util.Scanner;

public class Seventeenth {
    private static void sort(int[] a,int l,int r){
        //选择排序
//        for(int i=l;i<r;i++){
//            for(int j=i;j<r;j++){
//                if(a[i]>a[j+1]){
//                    int t=a[i];
//                    a[i]=a[j+1];
//                    a[j+1]=t;
//                }
//            }
//        }
        //冒泡排序
        //4 6
        //1 3 8 10 10 5 1 5 6 8
        for(int i=0;i<r-l;i++){
            for(int j=l;j<l+r-l-i;j++){
                if(a[j]>a[j+1]){
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),l=sc.nextInt(),r=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        sort(a,l,r);
        for(int x:a)System.out.print(x+" ");
    }
}
