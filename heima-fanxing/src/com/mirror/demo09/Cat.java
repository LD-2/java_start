package com.mirror.demo09;

public class Cat extends Animal{
    private int age;

    public Cat() {

    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return super.toString()+" age= "+age;
    }

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }
}
