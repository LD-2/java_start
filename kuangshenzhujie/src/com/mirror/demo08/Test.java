package com.mirror.demo08;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//创建运行时类的对象
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1=Class.forName("com.mirror.User");
        //获得类的名字
        System.out.println(c1.getName());  //获得类名 包名
        System.out.println(c1.getSimpleName());  //获得类名

        //获得类的属性
        Field[] fields = c1.getFields();//只能找到public属性
        for(Field x:fields){
            System.out.println(x);
        }

        Field[] f=c1.getDeclaredFields();//可以找到所有的属性 private也可以
        for(Field x:f){
            System.out.println(x);
        }

//        System.out.println(c1.getField("id"));//只能public
        System.out.println(c1.getDeclaredField("id"));

        //获得类的方法
        Method[] methods1=c1.getMethods(); //本类和父类的只有public的方法
        for(Method x:methods1){
            System.out.println("public      "+x);
        }
        Method[] methods2=c1.getDeclaredMethods();//本类的所有方法 包括私有
        for(Method x:methods2){
            System.out.println(""+x);
        }
        //指定方法
        Method toString1=c1.getMethod("toString",null);
        Method setName=c1.getDeclaredMethod("setName", String.class);
        System.out.println(toString1);
        System.out.println(setName);

        //获得指定的构造器
        System.out.println("获得指定的构造器");
        Constructor[] constructors1=c1.getConstructors();
        Constructor[] constructors2=c1.getDeclaredConstructors();
        for(Constructor x : constructors1){
            System.out.println(x);
        }
        for(Constructor x : constructors2){
            System.out.println(x);
        }
        Constructor constructor3=c1.getDeclaredConstructor(String.class,int.class,int.class);
        System.out.println("#"+constructor3);
    }
}
