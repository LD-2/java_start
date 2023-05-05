import java.util.Scanner;

public class Seventeenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str1=sc.next(),str2=sc.next();
//        System.out.println(str1.lastIndexOf('b'));
        boolean flag=false;
        if(str1.length()<str2.length()){
            String t=str1;
            str1=str2;
            str2=t;
        }
        for(int i=0;i<str1.length();i++){
            if(str1.indexOf(str2)!=-1){
                flag=true;
                break;
            }
            str1=str1.substring(1)+str1.charAt(0);
        }
        System.out.print(flag);
    }
}
