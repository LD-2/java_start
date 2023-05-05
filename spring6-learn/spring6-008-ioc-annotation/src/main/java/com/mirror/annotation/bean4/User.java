package com.mirror.annotation.bean4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
//    @Value("mirror")
    private String name;
//    @Value("20")
    private int age;

    public User(@Value("mirror") String name, @Value("20") int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

//    @Value("mirror")
    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

//    @Value("20")
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
