import java.util.Scanner;

public class Eleventh{
    public static void main(String[] args){
        int n=6;
        boolean flag=true;
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        while(flag){
            if(n--==0)break;
            for(;;){
                if(x%2!=0){
                    System.out.println(x);
                    x++;
                    break;
                }
                x++;
            }
        }
    }
}
