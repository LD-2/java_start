package com.mirror.demo09;

public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("线程vip "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        TestJoin t=new TestJoin();
        Thread thread=new Thread(t);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            if(i==200){
                thread.join();
            }
            System.out.println("普通无特权主线程 "+i);
        }
    }
}
