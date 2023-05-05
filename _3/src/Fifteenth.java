import java.util.Scanner;

public class Fifteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        while(x>0){
            int a=sc.nextInt(),b=sc.nextInt(),sum=0;
            if(a>b){
                int t=a;
                a=b;
                b=t;
            }
            for(int i=a+1;i<b;i++){
                // if(i%2!=0)sum+=i;
                if(i%2==1||i%2==-1)sum+=i;
            }
            System.out.println(sum);
            x--;
        }
    }
}
