package demo15;

public class Test {
    public static void main(String[] args) {
        Apple apple = new Apple();
        //没有名字初始化类 不用讲实例保存到变量中  匿名类
        new Apple().f();

        //多线程lambda学
        UserService userService=new UserService(){
            public void hello(){

            }
        };
    }
}
class Apple{
    public void f() {
        System.out.println("1");
    }
}

interface UserService{
    void hello();
}