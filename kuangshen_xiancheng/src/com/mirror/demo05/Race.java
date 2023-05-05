package com.mirror.demo05;

//实现Runnable接口就是对同一个对象多线程操作 其实是可以实现多继承
public class Race implements Runnable{
    private static String winnner;
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if(i%80==0&&Thread.currentThread().getName().equals("兔子")){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
            boolean flag =gameOver(i);
            if(flag)break;
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
        }
    }
    //判断是否完成比赛
    public boolean gameOver(int steps) {
        if(winnner!=null){
            return true;
        }{
            if(steps==100){
                winnner=Thread.currentThread().getName();
                System.out.println("Winner is "+winnner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race=new Race();
        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }
}
