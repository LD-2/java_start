import java.util.Scanner;

public class Third{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            String str1=sc.next();
            String str2=sc.next();
            if(str1.compareTo(str2)>0){
                if(str1.charAt(0)=='H'){
                    if(str2.charAt(0)=='B')System.out.println("Player2");
                    else System.out.println("Player1");
                }
                else System.out.println("Player1");
            }
            else if(str1.compareTo(str2)<0){
                if(str1.charAt(0)=='B'){
                    if(str2.charAt(0)=='G')System.out.println("Player2");
                    else System.out.println("Player1");
                }
                else System.out.println("Player2");
            }
            else System.out.println("Tie");
        }
    }
}
