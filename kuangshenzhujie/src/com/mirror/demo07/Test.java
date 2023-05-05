package com.mirror.demo07;

public class Test {
    public static void main(String[] args) {
        //获取系统类的加载器
        ClassLoader systemClassLoader = Test.class.getClassLoader();
        System.out.println(systemClassLoader);
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getPlatformClassLoader());
        System.out.println(ClassLoader.class);
        System.out.println("测试JDK内置类是谁加载的");
        System.out.println(ClassLoader.class.getClassLoader());
        System.out.println(Test.class);
        //获取系统类加载器的父类加载器-->扩展类加载器
        System.out.println("获取系统类加载器的父类加载器-->扩展类加载器");
        ClassLoader parent=systemClassLoader.getParent();
        System.out.println(parent);
        //获取扩展类加载器的父类加载器-->根加载器(C/C++)
        System.out.println("获取扩展类加载器的父类加载器-->根加载器(C/C++)");
        ClassLoader oldParent=parent.getParent();
        System.out.println(oldParent);
        //测试当前用户自定义的类是哪个加载器加载的
        System.out.println("测试当前用户自定义的类是哪个加载器加载的");
        try {
            ClassLoader classLoader =Class.forName("com.mirror.demo07.Test").getClassLoader();
            System.out.println(classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //测试JDK内置类是谁加载的
        System.out.println("测试JDK内置类是谁加载的");
        System.out.println(Object.class.getClassLoader());
    }
}