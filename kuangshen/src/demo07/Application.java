package demo07;

public class Application {
    //继承  继承的本质是对某一批类的抽象
    //java中只有单继承 没有多继承
    //extends意思是扩展 子类是父类的扩展 更有特性
    //继承是类与类之间的一种关系，除此之外 还有依赖 组合 聚合等
    //子类继承父类的所有方法
    //在java中所有的类都直接或者间接继承Object类
    //ctrl+H
    public static void main(String[] args) {
        Student newS = new Student();
        newS.say();
        System.out.println(newS.getMoney());
        Person student=new Person();
        System.out.println(student.getMoney());
    }
}
