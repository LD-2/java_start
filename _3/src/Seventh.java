import java.util.Scanner;

public class Seventh {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        boolean flag=true;
        int n=0;
        while(flag){
            n=sc.nextInt();
            if(n<=0)continue;
            flag=false;
        }
        int sum=0;
        for(int i=a;i<a+n;i++){
            sum+=i;
        }
        System.out.println(sum);
    }
}
