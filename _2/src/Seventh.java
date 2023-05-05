//java中判断字符串相等要用到 equals
import java.util.Scanner;

public class Seventh {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str1=sc.next(),str2=sc.next(),str3=sc.next();
        if(str1.equals("vertebrado")){
            if(str2.equals("ave")){
                if(str3.equals("carnivoro")){
                    System.out.println("aguia");
                }
                else System.out.println("pomba");
            }
            else {
                if(str3.equals("onivoro")){
                    System.out.println("homem");
                }
                else System.out.println("vaca");
            }
        }
        else {
            if(str2.equals("inseto")){
                if(str3.equals("hematofago")){
                    System.out.println("pulga");
                }
                else System.out.println("lagarta");
            }
            else {
                if(str3.equals("hematofago")){
                    System.out.println("sanguessuga");
                }
                else System.out.println("minhoca");
            }
        }
    }
}
