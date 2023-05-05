package demo11;

public class Application {
//    public static void displayObjectClassName(Object o){
//        System.out.println(o.getClass().getSimpleName()+"类的实例对象");
//    }
//    public static String newDisplayObjectClassName(Object o){
//        return o.getClass().getSimpleName();
//    }
    public static void main(String[] args){
        //instanceof  判断一个对象是什么类型

        //最外面的是Object类>Person>Student
        //instanceof是java 的一个二元操作符 是为了测试它左边的实例是不是右边类的实例  左边的实例对象是不是右边类的实例对象 或者 是不是右边类子类的实例对象 从而返回boolean类型

        //静态函数不能用用非静态方法
        //为什么同一个类里面的静态函数就不写类名直接调用这个类里面的静态方法
        //静态函数不可以继承

        //一个类里面只能有一个main
        //不在同一个包里面的用类中的方法 要导包
        //静态方法可以继承吗  可以
        //静态方法也可以实例化对象使用吗  可以 它这边的意思是不能直接访问非静态数据（实例变量），因为非静态数据是属于对象属性的，其只有在对象存在的时候才能引用。
        //但是静态方法不会被继承  没多态
        Object o=new Student();
        Student s=new Student();
        Person s2=new Student();
        Person p=new Person();
        s.displayObjectClassName(s);
        s2.displayObjectClassName(o);
        Student.displayObjectClassName(s);
        System.out.println(Person.newDisplayObjectClassName(p));
        System.out.println(Person.newDisplayObjectClassName(s));
        System.out.println(o.getClass());
        System.out.println(o instanceof Student);
        System.out.println(o instanceof Person);
        System.out.println(o instanceof Object);
        System.out.println(o instanceof Teacher);
        System.out.println(o instanceof String);
        System.out.println("-------------------------");
        Person.displayObjectClassName(o);

        //子类转换为父类 可能丢失一些方法 低转高
        //高转低 强制类型转换

    }
}
