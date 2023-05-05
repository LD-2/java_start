package com.mirror.demo12;

//静态代理
//试一下父类的引用可以指向子类的类的的实例对象吗  可以
//试一下接口的引用可以指向实现该接口的类的子类吗  可以
public class UnsafeBank {
    public static void main(String[] args) {
        Eat test01=new Person();
        Eat test02=new Cooker();
        test01.eat();
        test02.eat();

        Pet test03=new Dog();
        Pet test04=new BigDog();
        test03.shut();
        test04.shut();
    }
}
interface Eat{
    void eat();
}
class Person implements Eat{
    @Override
    public void eat() {
        System.out.println("person eat()");
    }
    public void drink() {
        System.out.println("person drink()");
    }
}
class Cooker extends Person{
    public void cook(){
        System.out.println("Cooker cook()");
    }
}
class Pet{
    public void shut(){
        System.out.println("Pet shut()");
    }
}
class Dog extends Pet{
    @Override
    public void shut() {
        System.out.println("Dog shut()");
    }
}
class BigDog extends Dog{
    @Override
    public void shut() {
        System.out.println("BigDog shut()");
    }
}

