package demo11;

public class Person {
    public static void displayObjectClassName(Object o){
        System.out.println(o.getClass().getSimpleName()+"类的实例对象");
    }
    public static String newDisplayObjectClassName(Object o){
        return o.getClass().getSimpleName();
    }
}
