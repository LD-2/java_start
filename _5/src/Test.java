import java.util.*;

public class Test {
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=sc.nextInt();
        String[] s=new String[n];int idx=0;
        boolean flag=true;
        String all="";
        while (n-->0){
            s[idx]=sc.next();
            if(s[idx].length()!=str.length());
            else{
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i)==s[idx].charAt(i))flag =false;
                    all=all+s[idx]+" ";
                    break;
                }
            }
            idx++;
        }
//        System.out.println(all);
        if(flag){
//            System.out.println(idx);
//            for(int i=0;i<idx-1;i++){
//                for(int j=i;j<idx-1;j++){
//                    if(s[i].compareTo(s[i+1])>0){
//                        String t=s[i];
//                        s[i]=s[i+1];
//                        s[i+1]=t;
//                    }
//                }
//            }
//            for(int i=0;i<idx;i++){
//                System.out.println(s[i]);
//            }
            List<String> list=new ArrayList<>();
            for(int i=0;i<s.length;i++) {
                String ss = s[i];
                list.add(ss);
            }
            Collections.sort(list);
            for(String ss:list){
                System.out.println(ss);
            }
        }
        else {
            String[] res=all.split(" ");
//            System.out.println(res[0]);
            int[] cnt=new int[res.length];
//            System.out.println(cnt[0]);
//            System.out.println(cnt[1]);
//            System.out.println(cnt[2]);
//            System.out.println();
//            System.out.println();
            for(int i=0;i<res.length;i++){
                for(int j=0;j<str.length();j++){
//                    System.out.println(str.charAt(j)+" "+res[i].charAt(j));
//                    System.out.println(i);
                    if(str.charAt(j)==res[i].charAt(j))cnt[i]++;
//                    System.out.println(cnt[i]);

                }
//                System.out.println();
            }


//            int[] cnt1=cnt;
//            System.out.println(cnt[2]);
//            Arrays.sort(cnt1);???

            int[] cnt1=new int[res.length];
            for(int i=0;i<res.length;i++){
                cnt1[i]=cnt[i];
            }
            Arrays.sort(cnt1);
            String end="";
//            System.out.println(res[2]);
//            System.out.println(cnt[0]);
//            System.out.println(cnt[1]);
//            System.out.println(cnt[2]);
//            System.out.println(cnt1[0]);
//            System.out.println(cnt1[res.length-1]);
//            System.out.println(cnt[0]);
//            System.out.println(cnt[1]);
//            System.out.println(cnt[2]);
            for(int i=0;i<res.length;i++){
//                System.out.println(res[i]);
                if(cnt1[res.length-1]==cnt[i]){
                    end=end+res[i]+" ";
                }
            }
//            System.out.println(end);
            String[] result=end.split(" ");
//            for(int i=0;i<result.length-1;i++){
//                for(int j=i;j<result.length-1;j++){
//                    if(result[i].compareTo(result[i+1])>0){
//                        String t=result[i];
//                        result[i]=result[i+1];
//                        result[i+1]=t;
//                    }
//                }
//            }
                List<String> list=new ArrayList<>();
                for(int i=0;i<result.length;i++) {
                    String ss = result[i];
                    list.add(ss);
                }
                Collections.sort(list);
                for(String ss:list){
                    System.out.println(ss);
                }

//                for(int i=0;i<result.length;i++){
//                System.out.println(result[i]);
            }
        }
    }
