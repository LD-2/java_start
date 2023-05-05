package com.mirror.demo09;

//模拟倒计时
public class TestSleep02{
    public static void main(String[] args) {
        try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
    public static void tenDown() throws InterruptedException{
        int cnt=10;
        System.out.println("Begin!");
        while (cnt>0){
            System.out.println(cnt--);
            Thread.sleep(1000);
        }
    }
}
