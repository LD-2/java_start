package com.mirror.demo04;


public class MainClass {
    public static void main(String[] args) {
        Parent<Integer> p1=new Child01<>();
        p1.setValue(66);
        System.out.println(p1.getValue());
        System.out.println("---------------");
        Child02 child=new Child02();
        child.setValue("mirror");
        System.out.println(child.getValue());
    }
}
