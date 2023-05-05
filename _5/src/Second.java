import java.util.Scanner;

public class Second {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char[] c=str.toCharArray();
        int cnt=0;
        for(int x:c){
            if(x>=48&&x<=57)cnt++;
        }
        System.out.print(cnt);
    }
}
