import java.util.Scanner;
public class Eighth{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String op=sc.next();
        int cnt=0;
        double sum=0;
        double[][] q = new double[12][12];
        for (int i = 0; i < 12; i ++ )
            for (int j = 0; j < 12; j ++ )
                q[i][j] = sc.nextDouble();
        for(int i=0;i<12;i++){
            for(int j=0;j<12;j++){
                if(j<i&&i<=5||j<12-1-i&&i>=6){
                    sum+=q[i][j];
                    cnt++;
                }
            }
        }
        if ("M".equals(op)) sum /= cnt;
        System.out.printf("%.1f\n", sum);
    }
}
