import java.util.Scanner;

public class Sixth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        double[][] a = new double[12][12];
        double sum=0;
        int cnt=0;
        for (int i = 0; i < 12; i ++ )
            for (int j = 0; j < 12; j ++ )
                a[i][j] = sc.nextDouble();
        for(int i=0;i<12;i++)
            for(int j=0;j<11-i;j++){
                sum+=a[i][j];
                cnt++;
            }
        if(str.equals("S"))System.out.printf("%.1f",sum);
        else System.out.printf("%.1f",sum/cnt);
    }
}
