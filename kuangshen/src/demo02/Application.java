package demo02;

public class Application {
    public static void main(String[] args){
        //使用new关键字创建的时候除了分配内存空间外 还会给创建好的对象进行默认的初始化 以及对类中的构造器的调用
        //类中的构造器也称构造方法 是在进行创建对象的时候必须调用的 构造器有以下两个特点 必须和类的名字相同 必须没有返回类型
        Student mirror=new Student();
        mirror.age=19;
        mirror.name="mirror";
        mirror.study();
        System.out.printf("name: %s, age: %d",mirror.name,mirror.age);
    }
}
