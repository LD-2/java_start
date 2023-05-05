package com.mirror.demo15;

//生产者、消费者、产品、缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer=new SynContainer();
        new Thread(new Producer(synContainer)).start();
        new Thread(new Consumer(synContainer)).start();
    }
}
//生产者
class Producer implements Runnable{
    SynContainer container;
    public Producer(SynContainer container) {
        this.container=container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产的第 "+i+" 只鸡.");
        }
    }
}
//消费者
class Consumer implements Runnable{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("消费的第 "+container.pop().id+" 只鸡.");
        }
    }
}
//缓冲区
class SynContainer{
    //容器大小
    Chicken[] chickens=new Chicken[10];
    int count=0;
    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //容器满了 就需要等待消费
        if(count==chickens.length){

            //通知消费者消费 让生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //没有满 就丢入产品
        chickens[count++]=chicken;
        //可以通知消费者消费
        this.notifyAll();
    }
    public synchronized Chicken pop(){
        //判断能否消费
        if(count==0){
            //等待生产者生产 消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken=chickens[count];
        this.notifyAll();
        //吃完了 通知生产者生产
        return chicken;
    }
}
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}
