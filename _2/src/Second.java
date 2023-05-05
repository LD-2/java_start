import java.util.Scanner;

public class Second {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x= scanner.nextInt(),y= scanner.nextInt();
        switch(x){
            case 1:
                System.out.printf("Total: R$ %.2f",y*4.00);
                break;
            case 2:
                System.out.printf("Total: R$ %.2f",y*4.50);
                break;
            case 3:
                System.out.printf("Total: R$ %.2f",y*5.00);
                break;
            case 4:
                System.out.printf("Total: R$ %.2f",y*2.00);
                break;
            case 5:
                System.out.printf("Total: R$ %.2f",y*1.50);
                break;

        }
    }
}
