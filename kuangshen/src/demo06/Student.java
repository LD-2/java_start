package demo06;

public class Student {
    //属性私有  封装的特性 类内部数据操作细节类内实现不允许外部干涉
    private String name;
    private int age;
    private char sex;
    //提供方法接口让外部操作数据

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        if(this.sex=='1')return "男";
        else return "女";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}