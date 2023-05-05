package com.bean;

public class UserB {
    private int age;
    private String name;

    @Override
    public String toString() {
        return "UserB{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserB(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public UserB() {
    }
}
