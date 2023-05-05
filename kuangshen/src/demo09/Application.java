package demo09;

public class Application {
    //理解动态绑定的好处 比如鸟类的叫声这个方法  可以分为很多个子类重写鸟类叫声方法  在写一个类实现对象调用使用任何一个鸟类叫声的时候 就不用一个一个建立不同鸟类的形参方法了 只用传入需要的就可以
    //父类类型的引用可以调用父类中的所有方法和属性 对于对应的子类只能调用父类中有的方法 如果子类重写了父类的方法则会使用子类中的重写方法
    //static的定义的方法的话用的还是父类的方法不用子类重写的
    //static方法不可以被重写
    //当父类引用指向子类对象，只会调用父类的静态方法，此行为并不具有多态性！所以子类重写父类的静态方法，并没有实际意义！
    //重写的是方法  父类的引用指向子类的作用是可以使用重写的方法和新方法
    //重写的只能是方法 @Override重写注解 ctrl+o快捷键
    //变量怎么重写 还可以重写吗
    //可以子类引用指向父类对象吗 不可以
    //写上构造函数 测试一下 就是父类的引用指向了 子类的对象
    public static void main(String[] args){
        System.out.println("这里是A继承B");
        System.out.println();
        System.out.println("A的实例化对象");
        A a=new A();
        a.f3();
        a.f2();
        System.out.println();
        System.out.println("B的引用指向A的对象");
        B b=new A();
        b.f3();
        b.f1();
        System.out.println();
        System.out.println("B的实例化对象");
        B b2=new B();
        System.out.println();
    }
}
