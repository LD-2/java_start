package demo10;

public class Application {
    //多态: 动态编译 类型的最终状态只有在执行的时候才知道   可扩展性
    //即同一方法可以根据发送对象不同而采用多种不同的行为方式
    //一个对象的实际类型是确定的，但是可以指向对象的引用类型有很多


    //一个对象的实际类型是确定的，但是可以指向对象的引用类型有很多（父类，有关系的类）
    //父类的引用指向子类的对象 可以调用子类的重写方法 没有的话调用父类自身的  不可以调用父类中没有的除非强制类型转换
    //多态是方法的多态 属性没有多态

    //多态类型的注意事项:
    /*
    * 1、多态是方法的多态 不是属性
    * 2、父类和子类有联系 类型转换异常 ClassCastException
    * 3、存在条件: 有继承关系 方法重写 父类的引用指向子类的实例对象
    *
    * static跟类走 不属于实例
    * final 常量 常量池
    * private 方法
    *
    * instanceof引用类型的转换
    * */
    public static void main(String[] args) {
        Person p = new Student();
        Object o = new Student();
        Student s = new Student();
        System.out.println(o.getClass());
        p.f1();
        ((Student)p).f2();
        s.f1();
        s.f2();
    }
}
