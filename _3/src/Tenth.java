import java.util.Scanner;

public class Tenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        for(int i=2;i<10000;i++){
            if(i%x==2)System.out.println(i);
        }
    }
}
