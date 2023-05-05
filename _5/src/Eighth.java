import java.util.Scanner;

public class Eighth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double k=sc.nextDouble();
        String str1=sc.next(),str2=sc.next();

        int cnt=0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)==str2.charAt(i))cnt++;
        }
        if((double)cnt/str1.length()>=k)System.out.println("yes");
        else System.out.println("no");
    }
}
