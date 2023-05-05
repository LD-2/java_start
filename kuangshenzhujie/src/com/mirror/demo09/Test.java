package com.mirror.demo09;

import com.mirror.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        //获得Class作业
        Class c1=Class.forName("com.mirror.User");

        //构造一个对象
        User u=(User)c1.newInstance();  //本质上是调用一个无参构造器 调用的是一个无参的因此要有无参构造的 而且还要有足够的访问权限
        System.out.println(u);

        //通过构造器创建对象
        Constructor constructor=c1.getDeclaredConstructor(String.class,int.class,int.class);
        User u2=(User)constructor.newInstance("mirror",2,20);
        System.out.println(u2);

        //通过反射获取一个方法
        User u3=(User)c1.newInstance();
        Method setName=c1.getMethod("setName", String.class);
        //in
        setName.invoke(u3,"666");
        System.out.println(u3);

        //通过反射操作属性
        User u4=(User)c1.newInstance();
        Field name=c1.getDeclaredField("name");
        //不能直接操作私有属性，我们需要关闭程序的安全检测，属性或者方法的setAccessible(true); 就可以访问了
        name.setAccessible(true);
        name.set(u4,"222");
        System.out.println(u4.getName());

    }
}
