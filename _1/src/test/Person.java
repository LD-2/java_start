package test;

public abstract class Person {
    private int age;

    public void setAge(int a) {
        age = a;
    }

    public void getAge() {
        System.out.println(age);
    }
}
