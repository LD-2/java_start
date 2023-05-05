package com.mirror.demo11;

public class TestDaemon {
    public static void main(String[] args) {

        //守护线程
        Thread thread=new Thread(new God());
        thread.setDaemon(true); //默认false 默认用户线程 可改为守护线程
        thread.start();

        //用户线程
        new Thread(new Person()).start();
    }
}
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑你！！");
        }
    }
}
class Person implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("历劫第 "+i+"天.");
        }
    }
}
