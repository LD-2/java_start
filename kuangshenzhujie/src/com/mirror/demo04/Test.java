package com.mirror.demo04;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1=Class.forName("com.mirror.demo04.User");
        Class c2=Class.forName("com.mirror.demo04.User");
        Class c3=Class.forName("com.mirror.demo04.User");
        Class c4=Class.forName("com.mirror.demo04.User");

        //一个类在内存中只有一个Class对象
        //一个类在被加载后 类的整个结构都会被封装在Class对象中
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
    }
}
class User{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
