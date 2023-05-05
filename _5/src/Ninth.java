import java.util.Scanner;

public class Ninth {
    public static void main(String[] args){
        //因为它的输入中没有空格所以就用另一种方法写
//        Scanner sc=new Scanner(System.in);
//        String str1=sc.nextLine(),str2=sc.nextLine();
////        System.out.println(' '-'d');
//        for(int i=0;i<Math.max(str1.length(),str2.length());i++){
//            int different=str1.charAt(i)-str2.charAt(i);
//            System.out.print(different+" ");
//            if(Math.abs(different)==('a'-'A'))continue;
//            else if(different==0)continue;
//            else if(different>0){
//                System.out.print(">");
//                return;
//            }
//            else {
//                System.out.print("<");
//                return;
//            }
//        }
//        System.out.print("=");
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine(),str2=sc.nextLine();
        str1=str1.toLowerCase();str2=str2.toLowerCase();
        int res=str1.compareTo(str2);
        if(res<0)System.out.print("<");
        else if(res==0)System.out.print("=");
        else System.out.print(">");
    }
}
