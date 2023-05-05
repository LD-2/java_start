package com.mirror.servlet;

public class Test {


    //静态代码块 在类加载时执行 并且只执行一次
    //静态代码块什么时候用
    //那就要看具体的需求是否想要在类加载时候执行一段代码  如果有需要的话  就可以把这个代码写到静态代码块 到时候就可以自然执行了
    //静态代码块就是java程序 为java程序员留的一个特殊的时机 这个时机就是类加载时机
    static {
        System.out.println("类加载了");
    }

    public static void main(String[] args) {

    }
}
