package com.mirror.demo03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test03 {
    @MyAnnotation01
    public void f1(){

    }
    @MyAnnotation02("666")
    public void f2(){

    }
}

@MyAnnotation01
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@interface MyAnnotation01{
    //注解的参数 数据类型 + 参数名();   当参数名是value时调用注解时可以不写value 否则要写  当参数值没有默认值的时候要写值
    String value() default "";
    String name() default "";
    int age() default 0;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation02{
    String value();
//    String name();
//    int age() default 0;
}
