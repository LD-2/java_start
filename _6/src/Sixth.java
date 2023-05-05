import java.util.Scanner;

public class Sixth {
    private static void print2D(int[][] a,int row,int col){
        for(int[] r:a) {
            for (int x : r)
                System.out.print(x);
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[][] a=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                a[i][j]=sc.nextInt();
        print2D(a,n,m);
    }
}
