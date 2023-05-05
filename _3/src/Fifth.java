import java.util.Scanner;

public class Fifth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int maxindex=0,max=0;
        for(int i=1;i<=100;i++){
            int x=sc.nextInt();
            if(x>max){
                max=x;
                maxindex=i;
            }
        }
        System.out.println(max+"\n"+maxindex);
    }
}
