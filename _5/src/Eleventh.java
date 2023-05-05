import java.util.Scanner;

public class Eleventh {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String newstr="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a'&&str.charAt(i)<='z'||str.charAt(i)<='Z'&&str.charAt(i)>='A') {
                if (str.charAt(i) != 'z' && str.charAt(i) != 'Z') newstr += (char) (str.charAt(i) + 1);
                else {
                    newstr += (char) (str.charAt(i) + 1 - 26);
                    System.out.print(str.charAt(i) + 1 - 26);
                }
            }
            else {
                newstr+=str.charAt(i);
            }
        }
        char[] c=newstr.toCharArray();
        for (char x:c){
            System.out.print(x);
        }
    }
}
