package com.mirror.demo07;

public class MainClass {
    public static void main(String[] args) {
        Box<Number> box=new Box<Number>();
        box.setValue(666);
        showBox(box);

        Box<String> box2=new Box<String>();
        box2.setValue("mirror");
        showBox(box2);
    }

    public static void showBox(Box<?> b){
        Object value = b.getValue();
        System.out.println(value);
    }




}
