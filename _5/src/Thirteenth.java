import java.util.Scanner;

public class Thirteenth {
    public static void main(String[] args){
        //写错了 题意是单词不是每个字符
//        Scanner scanner = new Scanner(System.in);
//        String str= scanner.nextLine();
//        String s1=scanner.nextLine();
//        String s2=scanner.nextLine();
////        System.out.println(str.substring(0,s1.length()+0));
//        String res="";
//        for(int i=0;i<str.length();){
//            if(i==str.length()-s1.length()){
//                if(str.substring(i,s1.length()+i).equals(s1)){
//                    res+=s2;
//                    i+=s1.length();
//                }
//                else {
//                    res += str.charAt(i);
//                    i++;
//                }
//            }else if(i<str.length()-s1.length()){
//                if (str.substring(i, s1.length() + i).equals(s1)) {
//                    res += s2;
//                    i += s1.length();
//                } else {
//                    res += str.charAt(i);
//                    i++;
//                }
//            }
//            else {
//                res += str.charAt(i);
//                i++;
//            }
//        }
//        for(int i=0;i<res.length();i++)System.out.print(res.charAt(i));
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String s1=sc.nextLine(),s2=sc.nextLine();
        String[] strs=str.split(" ");
        String res="";
        for(int i=0;i<strs.length;i++){
            if(strs[i].equals(s1))res+=s2+" ";
            else res+=strs[i]+" ";
        }
        for(int i=0;i<res.length();i++){
            System.out.print(res.charAt(i));
        }
    }
}
