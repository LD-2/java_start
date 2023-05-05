package com.mirror.demo02;

import java.lang.annotation.*;


public class Test02 {
    @MyAnnotation
    public void test(){

    }
}

//定义一个注解
//Target表示注解可以用在哪些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})

//Retention 表示注解在什么时候有效
//runtime>class>sources
@Retention(value= RetentionPolicy.RUNTIME)

//documented表示注解是否添加到JAVAdoc文档中
@Documented

//Inherited子类可以继承父类的注解
@Inherited
@interface MyAnnotation{

}
