package com.mirror.demo07;
//静态代理模式总结
//真实对象和代理对象都实现一个接口
//代理对象要代理真实角色

//好处:
    //代理对象可以做真实对象做不了的事情
    //真实对象要专注自己的功能
public class StaticProxy {
    public static void main(String[] args) {
//        new Thread(()-> System.out.println("啦啦啦")).start();
        new WeddingCompany(new Person("ld")).merry();
        System.out.println();
        new WeddingCompany(()->{
            System.out.println("666");
        }).merry();
    }
}
interface Merry{
    public abstract void merry();
}
class Person implements Merry{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void merry() {
        System.out.println(this.name+" is married!!");
    }
}
class WeddingCompany implements Merry{
    private Merry target;

    public WeddingCompany(Merry target) {
        this.target = target;
    }

    @Override
    public void merry() {
        this.before();
        this.target.merry();
        this.after();
    }
    public void before(){
        System.out.println("布置婚礼");
    }
    public void after(){
        System.out.println("收尾款");
    }
}

