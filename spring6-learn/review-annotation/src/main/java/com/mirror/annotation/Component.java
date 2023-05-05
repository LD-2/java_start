package com.mirror.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 标注注解的注解 叫做元注解。 @Target注解用来修饰@Component可以出现的位置
// 以下表示@Component注解可以出现在类上、属性上
//@Target(value={ElementType.TYPE,ElementType.FIELD})
// 以下表示注解可以出现在类上
//@Target(value = {ElementType.TYPE})
//如果注解的属性值数组 并且 数组中只有一个元素 则大括号可以省略
//@Target({ElementType.TYPE})
//1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成 .class 文件的时候，被其标注的注解被遗弃；
//
//2、RetentionPolicy.CLASS：注解被保留到class文件中，但jvm加载 .class 文件时候，被其标注的注解会被遗弃，这是默认的生命周期；
//
//3、RetentionPolicy.RUNTIME：注解不仅被保留到 .class 文件中，jvm 加载 .class 文件之后，被其标注的注解仍然存在，所以这个时候才可能通过反射机制读取注解的信息，而前两个生命周期中，通过反射机制读取不到注解信息的；
@Target(ElementType.TYPE)
//@Retention可以用来标注注解 最终保留在class文件中 并且可以被反射机制读取
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String value();
}
