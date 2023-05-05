import java.util.Scanner;

public class Seventh {
    public static void main(String[] args){
        int[] a=new int[26];
        Scanner scanner = new Scanner(System.in);
        String str= scanner.next();
        char[] c=str.toCharArray();
        for(int x:c) a[x-97]++;
        for(int x:c){
            if(a[x-97]==1) {
                System.out.print((char) x);
                return;
            }
        }
        System.out.print("no");
    }
}
