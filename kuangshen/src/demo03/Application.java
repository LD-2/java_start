package demo03;

public class Application {
    public static void main(String[] args){
        Person person=new Person();
        System.out.println(person.name);
    }
    //构造器:
    /*
    * 规则：无返回值 方法名和类名一致
    * 作用：初始化值 new的本质就是调用构造器
    * 注意点：如果有有参构造器时想用无参构造器时必须要显示显示
    * alt+insert快捷键
    * */
}
