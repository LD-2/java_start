import java.util.Scanner;

public class Fourteenth {
    private static void print(char[] c){
        for(int x:c)System.out.print((char)x);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str= scanner.nextLine();
        print(str.toCharArray());
    }
}
