import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        //每个字符都对应-128-127的数字  目前负数没有与之对应的字符
        //单引字符 双引串
        //java中的字符串有一个专门的类型String 类
//        String a="hello word";
        //格式化字符串
//        String str=String.format("perfect is %4d",100);
//        System.out.println(str);
//        String str1="33.32";
//        double dd=Double.parseDouble(str1);
//        System.out.println(dd);
//        System.out.println(""+dd);
//        Integer ddd=(int)dd;
//        String str2=ddd.toString();//转为对象转换
//        System.out.println(str2);

        //java中访问字符串中某个字符的位置需要通过调用API实现  数字lengthAPI  javalength()API
//        String str="mirror";
//        for(int i=0;i<str.length();i++){
//            System.out.print(2+'a');
//            System.out.print(str.charAt(i)+" ");
//        }
        //分割字符串
//        String str="mirror";
//        String[] strs=str.split("r");
//        System.out.println(strs[2]);
//        System.out.println(Arrays.toString(strs));
        //查找字符串中某个字符或者某个字串的首位置 存在输出 不存在输出-1
//        String str="mirror";
//        System.out.println(str.indexOf('r'));
//        System.out.println(str.indexOf("or"));
//        System.out.println(str.indexOf("iio"));
        //判断两个字符串是否相等
//        String str1="mirror";
//        String str2="ldld";
//        if(str1.equals(str2))System.out.println("Yes");
//        else System.out.println("No");
        //判断两个字符串的字典序大小负数表小于 0=  +>
//        String str1="Amirror";
//        String str2="aldld";
//        System.out.println(str1.compareTo(str2));
        //判断是否以某个字符串开始/结尾  前缀后缀
//        String str1="mirror";
//        String str2="ldld";
//        System.out.println(str1.startsWith("mirro"));
//        System.out.println(str2.endsWith("d"));
        //去掉首尾的空白字符
//        String str="  Hello mirror  \n";
//        System.out.println(str.trim());
        //全用小写字符/全用大写字符
//        String str="mirror";
//        System.out.println(str.toUpperCase());
//        String str2=str.toUpperCase();
//        System.out.println(str2);
//        System.out.println(str2.toLowerCase());
        //替换字符 替换字符串
//        String str="Hello Mirror";
//        System.out.println(str.replace("Mirror","mirror"));
//        System.out.println(str.replace('M','m'));
        //找出字符串中的字串
//        String str="mirror";
//        System.out.println(str.substring(1,3));
        //将字符串变为字符数组 这样方便找到其中的某一个元素和范围循环
//        String str="mirror";
//        char[] a=str.toCharArray();
//        for(char c:a){
//            System.out.print(c+" ");
//        }
        //String对象调用了以上api但是不会改变原串 是直接创建新串
        //如果想修改变化 增加时间空间利用率 就用StringBuilder 和 StringBuffer
//        StringBuilder sb = new StringBuilder("mirror");
//        sb.append('s');
//        System.out.println(sb);
//        for(int i=0; i<sb.length(); i++){
//            sb.setCharAt(i,(char)(sb.charAt(i)+1));
//        }
//        System.out.println(sb);
        //反转
//        StringBuilder sb = new StringBuilder("mirror");
//        System.out.println(sb.reverse());
//        System.out.println(sb);
    }
}
