package com.mirror.demo01;


//正压警告 不显示警告了
@SuppressWarnings("all")
public class Test01 {
    //Override 重写的注解
    @Override
    public String toString() {

        return super.toString();
    }

    @Deprecated  //不推荐使用此方法 但是还可以使用
    public void test01(){
        System.out.println("Test01");
    }

    public static void main(String[] args) {
        new Test01().test01();
    }
}
