import java.util.Scanner;

public class Nineteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] strs=str.split(",");
        String s=strs[0],s1=strs[1],s2=strs[2];
        int l=s.indexOf(s1),r=s.lastIndexOf(s2);
        if(l!=-1&&r!=-1&&l+s1.length()-1<r){
            System.out.print(r-(l+s1.length()-1)-1);
        }
        else System.out.print(-1);
    }
}
