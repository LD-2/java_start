import java.util.Scanner;

public class Ninteenth {
    private static int n;
    private static boolean[] bol=new boolean[n];
    private static int[] a=new int[n];
    private static void dfs(int u){
        if(u==n){
            for(int i=1;i<=n;i++) {
                System.out.print(a[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++){
            if(!bol[i]){
                a[i]=i;
                bol[i]=true;
                dfs(u+1);
                bol[i]=false;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        dfs(0);
    }
}
