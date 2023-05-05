import java.util.Scanner;

public class Sixteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] strs=str.split(" ");
        for(int i=strs.length-1;i>=0;i--){
            System.out.print(strs[i]+" ");
        }
    }
}
