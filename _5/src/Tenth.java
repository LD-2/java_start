import java.util.Scanner;

public class Tenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            System.out.printf("%s ",sc.next());
//        }
        int flag=0;
        String str=sc.nextLine();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                System.out.print(str.charAt(i));
                flag=0;
            }
            else {
                if(flag==0){
                    System.out.print(' ');
                    flag=1;
                }
                else continue;
            }
        }
    }
}
