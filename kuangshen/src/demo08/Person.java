package demo08;

public class Person {
    private String name;

    public Person() {
    }

    private int age;
    public void introduce(){
        System.out.printf("I am %s",this.getName());
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
