package com.mirror.demo05;

public class MainClass {
    public static void main(String[] args) {
        Test01 test=new Test01("mirror");
        System.out.println(test.getValue());

        Pair<String,Integer> pair=new Pair<>("mirror",666);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }
}
