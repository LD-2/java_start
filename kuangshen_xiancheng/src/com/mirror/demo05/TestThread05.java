package com.mirror.demo05;

public class TestThread05 implements Runnable{
    private int tickets;
    private String name;
    public TestThread05() {
        this.tickets =10;
    }
    @Override
    public void run() {
        while (true){
            if(tickets<=0)break;
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//            }
            System.out.println(Thread.currentThread().getName()+"抢到了第"+tickets--+"张票");
        }
    }
    public static void main(String[] args) {
        TestThread05 t5 = new TestThread05();
        new Thread(t5,"mirror").start();
        new Thread(t5,"ld").start();
        new Thread(t5,"zjy").start();
    }
}
