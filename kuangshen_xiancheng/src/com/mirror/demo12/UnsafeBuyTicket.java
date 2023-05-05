package com.mirror.demo12;


//这里结果出现买到票数重复的原因就是因为线程不同步造成的
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station=new BuyTicket();
        new Thread(station,"ld").start();
        new Thread(station,"mirror").start();
        new Thread(station,"zjy").start();
    }
}
class BuyTicket implements Runnable{
    private int ticketNums;
    boolean flag=true;
    public BuyTicket() {
        this.ticketNums = 100;
    }

    @Override
    public void run() {
        while(flag){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
            this.buy();
        }
    }

    //同步方法 锁了this
    public synchronized void buy(){

        if(ticketNums<=0){
            flag=false;
            return;
        }
        else {

            System.out.println(Thread.currentThread().getName()+"买到了第 "+ticketNums--+" 张票");
        }
    }
}
