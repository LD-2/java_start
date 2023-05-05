package demo03;
//alt+insert快捷键设置
public class Person {
    //一个类即使什么也不写 都会存在一个方法
    //构造方法 没有返回值 方法名和类名一样
    //实例化初始值
    //使用new关键字 本质就是调用构造器
    String name;
    public Person(){
        this.name="mirror";
    }

    //定义了有参构造，想用无参构造就必须使用显示的定义
    public Person(String str){
        this.name=str;
    }
}
