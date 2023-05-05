package com.mirror.demo02;
/**
 *<T>泛型标识 类型形参
 * 创建对象的时候显示定义数据类型
 */
public class MainClass {
    public static void main(String[] args) {

        //String
        Generic<String> stingGeneric=new Generic<>("mirror");
        System.out.println(stingGeneric.getKey());

        //Integer
        Generic<Integer> integerGeneric=new Generic<>(2);
        System.out.println(integerGeneric.getKey());

        //Object
        Generic generic=new Generic(999);
        System.out.println(generic.getKey());

        //同一个字节码文件，在一个jvm虚拟机堆内存中，只会生成一个对应的Class类对象
        System.out.println(integerGeneric.getClass());
        System.out.println(integerGeneric.hashCode());
        System.out.println(stingGeneric.getClass());
        System.out.println(stingGeneric.hashCode());
        System.out.println(generic.getClass());
        System.out.println(generic.hashCode());
    }
}
