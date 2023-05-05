import java.util.Scanner;

public class Fourth {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str= scanner.nextLine();
        char[] c=str.toCharArray();
        for(char x:c){
            System.out.print(x+" ");
        }
    }
}
