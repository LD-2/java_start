import java.util.Scanner;

public class Fourteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double[][] a=new double[12][12];
        double res=0.0;
        int cnt=0;
        String str=sc.next();
        for(int i=0; i<12; i++)
            for(int j=0; j<12; j++)
                a[i][j]=sc.nextDouble();
        for(int i=0; i<12; i++)
            for(int j=0; j<12; j++) {
                if (j > 11 - i) {
                    res += a[i][j];
                    cnt++;
                }
            }
        // for (int i = 0; i < 12; i ++ )
        // for (int j = 12 - i; j < 12; j ++ ) {
        //     System.out.println(a[i][j]);
        //     res += a[i][j];
        //     cnt += 1;
        // }
        if(str.equals("M"))res/=cnt;
        // System.out.println(cnt);
        System.out.printf("%.1f",res);
    }
}
