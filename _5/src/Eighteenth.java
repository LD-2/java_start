import java.util.Scanner;

public class Eighteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (true) {
            String str = sc.next();
            if(str.equals("."))break;
            for(int i=1;i<=str.length();i++) {
                if(str.length()%i==0){
                    String res="";
                    for(int j=1;j<=str.length()/i;j++){
                        res+=str.substring(0,i);
                    }
                    if(res.equals(str)){
                        System.out.println(str.length()/i);
                        break;
                    }
                }
            }
        }
    }
}
