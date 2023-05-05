package com.mirror.bean;

public class User {
    private int age;
    private String userName;
    private String passWord;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public int getAge() {
        System.out.println("getAge()方法执行了");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getEmail() {
        return "1392556557@qq.com";
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public User(int age, String userName, String passWord) {
        this.age = age;
        this.userName = userName;
        this.passWord = passWord;
    }

    public User() {

    }
}
