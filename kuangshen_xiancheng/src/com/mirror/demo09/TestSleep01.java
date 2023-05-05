package com.mirror.demo09;


//模仿网络延迟 : 放大问题的发生性   此实验中可以发现多个线程操作同一个对象会不安全
public class TestSleep01 implements Runnable {
    private int tickets;

    public TestSleep01() {
        this.tickets = 10;
    }

    @Override
    public void run() {
        while(tickets>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第 "+tickets-- +" 张票");
        }
    }
    public static void main(String[] args) {
        TestSleep01 t=new TestSleep01();
        new Thread(t,"mirror").start();
        new Thread(t,"ld").start();
    }
}
