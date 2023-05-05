import java.util.Scanner;

public class Fourth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
//        double[][] a=new double[12][12];
        double[] sum=new double[12];
        int l1=sc.nextInt();
        String l2=sc.next();
        for (int i=0;i<12;i++)
            for (int j=0;j<12;j++)
                sum[i]+=sc.nextDouble();
        if(l2.equals("S")) System.out.printf("%.1f",sum[l1]);
        else System.out.printf("%.1f",sum[l1]/12);
    }
}
