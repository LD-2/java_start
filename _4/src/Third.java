import java.util.Scanner;

public class Third {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double[] a=new double[100];
        for(int i=0;i<100;i++){
            a[i]=sc.nextDouble();
            if(a[i]<=10){
                System.out.print("A["+i+"] = ");
                System.out.printf("%.1f\n",a[i]);
            }
        }
    }
}
