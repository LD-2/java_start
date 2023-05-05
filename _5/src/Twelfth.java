import java.util.Scanner;

public class Twelfth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String res="";
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(0)+str.charAt(1));
        for(int i=0;i<str.length();i++){
            res+=(char)(str.charAt(i)+str.charAt((i+1)%str.length()));
        }
        for(int i=0;i<str.length();i++){
            System.out.print(res.charAt(i));
        }
    }
}
