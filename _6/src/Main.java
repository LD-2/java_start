import java.util.Arrays;

public class Main {
    //函数由哪几个部分构成的 修饰符（修饰符包括private、static等）、返回类型、函数名、由0个或者多个形参构成的函数列表以及函数体
    //编写函数 调用函数
    //函数的调用完成两项工作：传入一个实参把实参赋值给形参  主调函数的执行被暂停，执行被调用函数，然后返回主调函数的执行
//    private static int fact(int val){
//        int res=1;
//        for(int i=1;i<=val;i++){
//            res*=i;
//        }
//        return res;
//    }
//    public static void main(String[] args){
//        int res=fact(5);
//        System.out.printf("5! is %d.",res);
//    }

    private static int[] newArray(){
        int[] a={2,4,8};
        return a;
    }
    public static void main(String[] args){
        int[] a=newArray();
        System.out.println(Arrays.toString(a));
        String str=newString();
        System.out.println(str);
        f1();
        f4();
        f2();
        f3();
        f4();
        int b=2;
        System.out.println(b);
        f5(b);
        System.out.println(b);
        String str1="mirror";
        System.out.println(str1);
        f6(str1);
        System.out.println(str1);
        StringBuilder sb=new StringBuilder("");
        f7(sb);
        System.out.println(sb);
        f8(sb);
        System.out.println(sb);
        int[] arrays={5,4,3,2,1,0};
        f9(arrays);
        for(int x:arrays)System.out.print(x);
        //java中 基本类型的 值相同赋值 是只变量指向同一个值的地址 当这个变量改变的时候 是此变量指向的位置(地址)变了  而不是指向的内容变了。
        Integer y=9;
        System.out.println(y);
//        System.out.println(System.identityHashCode(y));
        f10(y);
        System.out.println(y);
        System.out.println(System.identityHashCode(y));
        Integer i=100;
        Integer j=100;
        System.out.println(System.identityHashCode(i)==System.identityHashCode(j));
        int k=100;
        int l=100;
        System.out.println(System.identityHashCode(k)==System.identityHashCode(l));
        //java中对象 引用类型的 赋值改变值 是 地址的传递 是地址指向的内容的改变
        StringBuilder str3=new StringBuilder("mirror");
        str3.append("666");
        StringBuilder str4=str3;
        str4.append("888");
        System.out.println(str4);
        System.out.println(str3);
        //java中没有swap函数  是因为它改变不了地址里面的内容  因为java中没有指针的概念 c++有指针的概念
        Integer aa=6;
        Integer bb=9;
        swap(aa,bb);
        System.out.printf("%d,%d",aa,bb);
        //函数重载  System.out.println()就是很经典的函数重载
        System.out.println();
        double q=22.0,qq=30;
        System.out.println(max(q,qq));
    }
    public static String newString(){
        return "mirror";
    }
    //本章我们只使用了静态成员变量和静态成员函数
    //变量的作用域
    //定义在类中的变量为成员变量 可以被此类所有成员函数使用
    //函数内定义的变量为局部变量 只能在函数内部使用
    //重名时优先使用 局部变量
    private static int x=4;
    private static void f1(){
        int x=2;
        System.out.println(x);
    }
    private static void f2(){
        x+=5;
        System.out.println(x);
    }
    private static void f3(){
        System.out.println(x);
    }
    private static void f4(){
        System.out.println(x);
    }
    //传值 传地址
    //八大基本类型和String类型进行值传递  对形参的修改不影响实参的值  byte short int long float double boolean char String
    //给String类型进行修改时 会给String赋全新的值 开辟新地址存值
    private static void f5(int b){
        b++;
    }
    private static void f6(String str1){
        str1="ldld";
    }
    //引用传递
    //除String以外的其它非基本类型数据都是引用传递，例如：数组、StringBuilder 等都是引用传递
    private static void f7(StringBuilder str){
        str.append("mirror22");
        //传入了地址 因此str这个形参的地址指向的也是外面sb的地址  因此这里str改变了 外面的sb也会改变 因为地址时同一个的
    }
    private static void f8(StringBuilder str){
        str=new StringBuilder("ldld");
        //这里形参str改变了但是sb没改变的原因是因为str的地址和sb的地址不是同一个地址 因此形参str改变了但是不影响外部实参sb的改变
    }
    //这个地址里面存的是这个 数值 本质都是传递值 但是一个传递的是值不是具体的地址  而这个是传递了地址 这个地址里面是存的这个数 因此可以直接对这个地址里面的内容进行操作
    private static void f9(int[] arr){
        for(int i=0,j=arr.length-1;i<j;i++,j--){
            int t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
        }
    }
    //返回类型和return语句 返回值为void类型的不要求函数体有return;语句 这类函数中编译器会给其分配隐式的return;语句 非void返回类型时 必须有对应的返回类型
    //java中是没有swap函数的
    private static void f10(Integer yy){
        yy=999;
        System.out.println(System.identityHashCode(yy));
    }
    //java中基本类型的地址问题 当两个变量的值相同时 意思时两个变量指向了同一个值的地址 改变一个变量只是改变了这个变量的指向 而不影响另一个变量的指向！！！！
    //java中没有swap函数  是因为它改变不了地址里面的内容
    //java中基本数据类型和对象的引用 逻辑 存在栈中  数据存储在堆中  基本数据类型局部变量存在栈上 全局存在堆中
    private static void swap(Integer a,Integer b){
        Integer t=a;
        a=b;
        b=t;
    }
    //函数重载
    private static int max(int a,int b){
        if(a>b)return a;
        else return b;
    }
    private static double max(double a,double b){
        if(a>b)return a;
        else return b;
    }
    //递归写法 可以通过画树的方法 进行递归搜索树 查看思路

}
