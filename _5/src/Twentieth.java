import java.util.Scanner;

public class Twentieth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            int n=sc.nextInt();
            if(n==0)break;
//            String[] strs=new String[n];
            StringBuilder[] strs=new StringBuilder[n];
            for (int i= 0; i < n; i++) {
                strs [i] = new StringBuilder("");
            }
            String s=sc.next();
            strs[0].append(s);
            strs[0]=strs[0].reverse();
            int min=strs[0].length();
            for(int i=1;i<n;i++) {
//                strs[i] = sc.next();
                String ss=sc.next();
                strs[i].append(ss);
                strs[i]=strs[i].reverse();
                if (min > strs[i].length()) {
                    min = strs[i].length();
                }
            }
            String res="";
            StringBuilder ress=new StringBuilder(res);
            for(int i=0;i< min;i++){
                char c=strs[0].charAt(i);
                boolean flag=true;
                for(int j=1;j< strs.length;j++){
                    if(c!=strs[j].charAt(i)){
                        flag=false;
                        break;
                    }
                }
                if(flag==false)break;
                if(flag)ress.append(c);
            }
            System.out.println(ress.reverse());
        }
    }
}