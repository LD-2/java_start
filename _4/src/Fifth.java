import java.util.Scanner;

public class Fifth {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double[][] a = new double[12][12];
        double sum = 0;
        int cnt=0;
        String str=sc.next();

        for (int i = 0; i < 12; i ++ )
            for (int j = 0; j < 12; j ++ )
                a[i][j] = sc.nextDouble();

        for (int i = 0; i < 12; i++)
            for (int j = i+1; j < 12; j++){
                sum+=a[i][j];
                cnt++;
            }


        // for (int i = 0; i < 12; i ++ )
        // for (int j = i + 1; j < 12; j ++ ) {
        //     sum += a[i][j];
        //     cnt += 1;
        // }

        if(str.equals("S")) System.out.printf("%.1f",sum);
        else System.out.printf("%.1f",sum/cnt);
    }
}
