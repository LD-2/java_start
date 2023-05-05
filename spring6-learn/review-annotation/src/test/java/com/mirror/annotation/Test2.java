package com.mirror.annotation;

import org.junit.Test;

public class Test2 {
    @Test
    public void testAnnotation() throws Exception{
        //通过反射获取某个类上的注解
        Class<?> aClass = Class.forName("com.mirror.bean.User");
        //判断这个类上是否有这个注解
        System.out.println(aClass.isAnnotationPresent(Component.class));
        if (aClass.isAnnotationPresent(Component.class)) {
            //获取类上的注解
            Component annotation = aClass.getAnnotation(Component.class);
            //访问注解的属性
            System.out.println(annotation.value());
        }
    }
}
