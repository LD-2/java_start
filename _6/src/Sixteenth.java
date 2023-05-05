import java.util.Scanner;

public class Sixteenth {
    private static int get_unique_count(int[] a,int n){
        boolean[] b=new boolean[1001];
        int cnt=0;
        for (int i=1;i<=n;i++){
            if(!b[a[i]]){
                cnt++;
                b[a[i]]=true;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n+1];
        for(int i=1;i<=a.length-1;i++)a[i]=sc.nextInt();
        System.out.print(get_unique_count(a,n));
    }
}
