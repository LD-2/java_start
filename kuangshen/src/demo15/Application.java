package demo15;

public class Application {
    public static void main(String[] args) {
        Outer outer=new Outer();
        Outer.Inner inner=outer.new Inner();
        //局部内部类
        class Inner{

        }
    }

}
//一个java文件中可以有多个类但是能有一个public类
