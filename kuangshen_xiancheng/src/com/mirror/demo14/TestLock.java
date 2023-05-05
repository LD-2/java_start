package com.mirror.demo14;

import java.util.concurrent.locks.ReentrantLock;

//Lock只有代码块锁 synchronized有代码块锁和方法锁
public class TestLock {
    public static void main(String[] args) {
        TestLock02 tickets=new TestLock02();
        new Thread(tickets).start();
        new Thread(tickets).start();
        new Thread(tickets).start();
    }
}
class TestLock02 implements Runnable{
    private int tickets;

    private final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        try {
            lock.lock();
            while (tickets>0){
                System.out.println(tickets--);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public TestLock02() {
        this.tickets = 10;
    }
}
