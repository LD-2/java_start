package com.mirror.demo03;

//方式2
public class TestThread03 implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<=200;i++){
            System.out.println("子线程"+i);
        }
    }
    public static void main(String[] args) {
        TestThread03 t3 = new TestThread03();
        new Thread(t3).start();
        for(int i=1;i<=200;i++){
            System.out.println("主线程"+i);
        }
    }
}
