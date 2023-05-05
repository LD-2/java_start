import java.util.Scanner;

public class Twelfth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[] =new int[n];
        int min=0;
        a[0]=sc.nextInt();
        for(int i=1;i<n;i++){
            a[i]=sc.nextInt();
            if(a[min]>a[i])min=i;
        }
        System.out.println("Minimum value: "+a[min]);
        System.out.println("Position: "+min);
    }
}
