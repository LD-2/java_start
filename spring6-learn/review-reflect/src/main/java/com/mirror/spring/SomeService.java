package com.mirror.spring;

public class SomeService {
    public void doSome(){
        System.out.println("SomeService的doSome()方法执行了");
    }

    public String doSome(String name){
        System.out.println("SomeService的doSome(String name)方法执行了");
        return name;
    }
    public String doSome(String name,int age){
        System.out.println("SomeService的doSome(String name,int age)方法执行了");
        return name+age;
    }
}
