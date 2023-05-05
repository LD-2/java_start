import java.util.Scanner;

public class Eighteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while (n>0){
            int x= sc.nextInt(),sum=0;
            if(x==1){

            }
            else{
                sum=1;
                for(int i=2;i<=x/i;i++){
                    if(x%i==0){
                        sum+=i;
                        if(x/i!=i)sum+=x/i;
                    }
                }
            }
            if(sum==x)System.out.println(x+" is perfect");
            else System.out.println(x+" is not perfect");
            n--;
        }
    }
}
