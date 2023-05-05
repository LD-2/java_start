package demo04;

public class Application {
    public static void main(String[] args){
        Pet dog=new Pet();
        dog.shout();
        dog.name="lala";
        dog.age=2;
        System.out.printf("name: %s,age: %d\n",dog.name,dog.age);
    }
}
