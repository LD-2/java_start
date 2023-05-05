import java.util.Scanner;

public class Third {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int cnt=0;
        for(int i=0;i<6;i++){
            double x=sc.nextDouble();
            if(x<0)continue;
            else cnt++;
        }
        System.out.println(cnt+" positive numbers");
    }
}
