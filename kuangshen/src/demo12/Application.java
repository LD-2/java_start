package demo12;


//导入静态函数
import static java.lang.Math.random;

//static中不可以用this
//static方法中  对于static的调用可以直接类名.方法名  也可以 实例对象.方法    但是对于非static属性或者方法只能实例调用 因为静态和类一起加载  如果没实例对象找不到要用的方法
//如果此方法中已经有了这个类就不用 写前缀 否则要导包
//static方法可以被继承  但是不会被重写
//同步一个包下类就可以使用  方法等可以使用 导包导类导方法
public class Application {
    private static int a;
    private int b;
    public void f1(){
        System.out.println("f1()");
    }
    public static void f2(){
        System.out.println("f2()");
    }
    public static void main(String[] args) {
        new New();
//        new Application().f1();
//        Application aa=new Application();
//        f2();
//        random();
//        new Application().b=3;
//        a=666;
//        New.f3();
    }
}
