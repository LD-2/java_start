import java.util.Arrays;
import java.util.Scanner;

public class Fifteenth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str=str1.substring(0,str1.length()-1);
        String[] strs=str.split(" ");
        Integer[] arr=new Integer[strs.length];
        for(int i=0;i<strs.length;i++){
            arr[i]=strs[i].length();
        }
        Arrays.sort(arr,(x,y)->{
            return y-x;
        });
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()==arr[0]){
                System.out.print(strs[i]);
                break;
            }
        }
    }
}
