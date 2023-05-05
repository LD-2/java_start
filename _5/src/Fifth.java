import java.util.Scanner;

public class Fifth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        char c=sc.next().charAt(0);
        char[] strc=str.toCharArray();
        for(char x:strc){
            if(x==c)System.out.print('#');
            else System.out.print(x);
        }
    }
}
