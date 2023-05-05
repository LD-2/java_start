import java.util.Scanner;

public class Thirteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double[][] a=new double[12][12];
        int col=sc.nextInt();
        double res=0.0;
        String str=sc.next();
        for (int i=0;i<12;i++)
            for (int j=0;j<12;j++)
                a[i][j]=sc.nextDouble();
        for (int i=0;i<12;i++)
            for (int j=0;j<12;j++)
                if(j==col)res+=a[i][j];
        if(str.equals("M"))res/=12;
        System.out.printf("%.1f",res);
    }
}
