package demo08;

public class Student extends Person{
    private String name;

    public Student() {
        super();
    }

    public void introdue(){
        System.out.println("I am 666");
    }
    public void test(){
        this.introdue();
        introdue();
        super.introduce();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
