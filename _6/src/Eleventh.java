import java.util.Scanner;

public class Eleventh {
    private static int sum(int l,int r){
        int sum=0;
        while(l<=r){
            sum+=l++;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int l=sc.nextInt(),r=sc.nextInt();
        System.out.println(sum(l,r));
    }
}