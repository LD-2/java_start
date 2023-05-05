package com.mirror.spring;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class aTestReflect {
    @Test
    public void test1() throws Exception{
        //获取类
        Class<?> aClass = Class.forName("com.mirror.spring.SomeService");
        //获取方法
        Method doSome = aClass.getDeclaredMethod("doSome");
        //这个是无参的就不用 获取参数了
        //找一个对象进行 调用
        Object o = aClass.newInstance();
        Object invoke = doSome.invoke(o);
        System.out.println(invoke);

        System.out.println("------------");
        Method doSome1 = aClass.getDeclaredMethod("doSome", String.class, int.class);
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        Object o1 = declaredConstructor.newInstance();
        Object invoke1 = doSome1.invoke(o1,"mirror",666);
        System.out.println(invoke1);
    }

    @Test
    public void test2()throws Exception{
//        需求：假设你现在已知以下信息：
//        1. 有这样一个类，类名叫做：com.mirror.spring.User.
//        这个类符合javabean规范。属性私有化，对外提供公开的setter和getter方法。
//        3. 你还知道这个类当中有一个属性，属性的名字叫做 age
//        4. 并且你还知道age属性的类型是int类型。请使用反射机制调用set方法，给User对象的age属性赋值。

        String className ="com.mirror.spring.User";
        String propertyName = "age";
        //获取类信息
        Class<?> aClass = Class.forName(className);
        //获取属性
        Field age = aClass.getDeclaredField(propertyName);
        //获取set方法
        Method setAge = aClass.getDeclaredMethod("set"+propertyName.toUpperCase().charAt(0)+propertyName.substring(1),age.getType());
        //获取对象
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        Object o = declaredConstructor.newInstance();
        setAge.invoke(o,20);
        System.out.println(o);
    }
}
