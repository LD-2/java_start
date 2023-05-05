import java.util.Scanner;

public class Thirteenth {
    private static void copy(int[] a,int[] b,int size){
        for(int i=0;i<size;i++){
            b[i]=a[i];
        }
        for(int x:b){
            System.out.print(x+" ");
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int na=scanner.nextInt(),nb= scanner.nextInt(),size=scanner.nextInt();
        int[] a=new int[na],b=new int[nb];
        for(int i=0;i<na;i++)a[i]= scanner.nextInt();
        for(int i=0;i<nb;i++)b[i]= scanner.nextInt();
        copy(a,b,size);
    }
}
