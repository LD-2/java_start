package com.mirror.demo09;

//礼让不一定成功
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield=new MyYield();
        new Thread(myYield,"A线程").start();
        new Thread(myYield,"B线程").start();
    }
}
class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"停止执行");
    }
}
