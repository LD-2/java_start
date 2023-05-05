package demo15;

public class Outer {
    private int id=10;
    public void out(){
        System.out.println("外部类方法");
    }
    public class Inner {
        public void in(){
            System.out.println("内部类方法");
            //获得外部类的私有属性
        }
        public void getId(){
            System.out.println(id);
        }
    }
}
