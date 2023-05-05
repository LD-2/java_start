package demo09;

public class A extends B {
    String name="555";
    public A() {
        System.out.println("A的构造函数");
    }
//    public void f1(){
//        System.out.println("A的方法f1");
//    }

    @Override
    public void f1() {
//        super.f1();
        System.out.println("A的方法f1");
    }

    public void f2() {
        System.out.println("lalalala");

    }
    public static void f3(){
        System.out.println("A的静态方法");
    }
}
