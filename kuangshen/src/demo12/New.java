package demo12;

//静态代码和类一起执行 且执行一次
//执行顺序  静态>匿名>构造
public class New {
    //赋初始值
    {
        System.out.println("匿名代码块");
    }
    static{
        System.out.println("静态代码块");
    }
    New(){
        System.out.println("构造方法");
    }
    public static void f3(){
        System.out.println("f2()");
    }
//    public static void main(String[] args){
//
//    }
}
