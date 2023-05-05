package com.mirror.demo05;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Person.class);
        System.out.println(new Person().getClass());
        System.out.println(Class.forName("com.mirror.demo05.Person"));
        System.out.println(Integer.TYPE);
        System.out.println(Teacher.class.getSuperclass());
    }
}
class Person{
    String name;
    int age;
}
class Teacher extends Person{

}
class Student extends Person{

}
