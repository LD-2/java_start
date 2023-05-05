public class Main {
    public static void main(String[] args){
        //以类的方式组织代码，以对象的组织封装数据
        //封装 继承 多态
        //对象是一个具体的事物 类是一类抽象的事物  类是对象的模板

        
        //方法：静态方法 非静态方法
        //静态方法可以直接调用 类名.方法名  非静态方法需要实例化再调用
        //同一个类中的 两个静态方法可以直接调用 同一个类中的两个非静态也可以直接互相调用 但是一静态一非静态不可以 static是和类一起加载的
        Name.NamePrint("mirror");
        Name name=new Name();
        name.NameGet("666");
        new Name().NameGet("888");

        Person person=new Person();
        System.out.println(person.name);
        change(person);
        System.out.println(person.name);
    }
    public static void f1(){
        f2();
//        f3();
    }
    public static void f2(){

    }
    public void f3(){
        f1();
    }
    public static void change(Person person){
        person.name="mirror";
    }
 }
 class Person{
    String name;
 }
