package demo08;

public class Application {
    public static void main(String[] args){
        //私有的东西无法被继承  super 调用父类的 属性或者方法 前提不是私有的
        //this()自身的构造函数调用    super()父类的构造函数调用    都要放在构造函数的首行  隐形默认自动先执行父类的无参
        //因为当一个类定义了有参构造函数 如果想使用无参构造函数就需要显示定义无参构造函数  因此如果子类构造函数中想用sper()无论显隐时要确定 父类中有没有无参构造函数
        Student s1=new Student();
        s1.test();
        
    }
}
