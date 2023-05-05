import java.util.Scanner;

public class Fifteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        double res=0.0;
        int cnt=0;
        double[][] a=new double[12][12];
        for (int i=0;i<12;i++)
            for (int j=0;j<12;j++)
                a[i][j]=sc.nextDouble();
        for (int i=0;i<12;i++)
            for (int j=0;j<12;j++){
                if(j<i){
                    res+=a[i][j];
                    cnt++;
                }
            }
        if(str.equals("M"))res/=cnt;
        System.out.printf("%.1f",res);
    }
}
