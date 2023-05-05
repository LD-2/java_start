import java.util.Scanner;

public class Sixteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double[][] a=new double[12][12];
        String str=sc.next();
        int cnt=0;
        double res=0.0;
        for (int i=0; i<12;i++)
            for (int j=0; j<12;j++)
                a[i][j]=sc.nextDouble();
       for (int i=0; i<12;i++)
           for (int j=0;j<12;j++){
               if(j<i&&j>11-i){
                   res+=a[i][j];
                   cnt++;
               }
           }
       if(str.equals("M"))res/=cnt;
       System.out.printf("%.1f",res);
    }
}
