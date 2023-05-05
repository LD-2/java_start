import java.util.Scanner;

public class Fourth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        if(a>b){
            int t=a;
            a=b;
            b=t;
        }
        int sum=0;
        for(int i=a+1;i<b;i++){
            if(i%2==0)continue;
            else sum+=i;
        }
        System.out.println(sum);
    }
}
