import java.util.Scanner;

public class Thirteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int c=0,r=0,f=0,total=0;
        while(num>0){
            int x=sc.nextInt();
            switch(sc.next()){
                case "C":
                    c+=x;
                    total+=x;
                    break;
                case "R":
                    r+=x;
                    total+=x;
                    break;
                case "F":
                    f+=x;
                    total+=x;
                    break;
            }
            num--;
        }
        System.out.println("Total: "+total+" animals");
        System.out.println("Total coneys: "+c);
        System.out.println("Total rats: "+r);
        System.out.println("Total frogs: "+f);
        System.out.printf("Percentage of coneys: %.2f ",(double)c/total*100);System.out.println("%");
        System.out.printf("Percentage of rats: %.2f ",(double)r/total*100);System.out.println("%");
        System.out.printf("Percentage of frogs: %.2f ",(double)f/total*100);System.out.println("%");

//        System.out.printf("%.2f",(double)3/10);
//        System.out.printf("%.2f",(double)(3/10));
    }
}
