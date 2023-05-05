package com.mirror.demo11;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MainClass {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //泛型与反射
        //反射常用的泛型类  Class<T>  Constructor<T>
        Class class1=Person.class;
        Constructor constructor1=class1.getConstructor();
        Object o = constructor1.newInstance();
        System.out.println(o.getClass().getSimpleName());


        System.out.println("---------------");
        Class<Person> class2=Person.class;
        Constructor<Person> constructor2=class2.getConstructor();
        Person person = constructor2.newInstance();
        System.out.println(person.getClass().getSimpleName());
        //不用强转了
    }
}
