//这一题用曼哈顿距离也可以(曼哈顿距离简单)
import java.util.Scanner;

public class Twentieth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int mid=n/2+1,cnt1=0,cnt2=0;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if(i<n/2+1){
                    if(j>=mid-cnt1&&j<=mid+cnt1) System.out.print("*");
                    else System.out.print(" ");
                }
                else if(i>n/2+1){
                    if(j>=mid-cnt2&&j<=mid+cnt2)System.out.print("*");
                    else System.out.print(" ");
                }
                else{
                    cnt2=cnt1;
                    System.out.print("*");
                }
            }
            cnt1++;
            cnt2--;
            System.out.println();
        }
    }
}
