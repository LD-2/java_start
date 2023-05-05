package demo07;

public class Person {
    private String name;
    private int age;
    private String money="666";

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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
    public void say(){
        System.out.println("Hello!");
    }
}
