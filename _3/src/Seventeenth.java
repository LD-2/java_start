import java.util.Scanner;

public class Seventeenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (true){
            int a=sc.nextInt(),b=sc.nextInt();
            if(a<b){
                int t=a;
                a=b;
                b=t;
            }
            if(!(a>0)||!(b>0))break;
            int sum=0;
            for(int i=a;i<=b;i++){
                sum+=i;
                System.out.print(i+" ");
            }
            System.out.println("Sum="+sum);
        }
    }
}
