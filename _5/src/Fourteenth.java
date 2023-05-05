import java.util.Scanner;

public class Fourteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while (n-->0) {
            String str = sc.next();
            str+=' ';
//            System.out.println(str);
            int max=1;
            int cnt=1;
            String res=str.charAt(0)+" "+max;
            for(int i=0;i<str.length()-1;i++){
                if(str.charAt(i)==str.charAt(i+1)){
                    cnt++;
                }
                else {
                    if(max<cnt){
                        max=cnt;
                        res=str.charAt(i)+" "+max;
                        cnt=1;
                    }
                    else cnt=1;
                }
            }
            System.out.println(res);
        }
    }
}
