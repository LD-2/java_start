package com.mirror.demo01;

//方式1
class TestThread extends Thread {
    @Override
    public void run() {
        for(int i=1;i<=200;i++){
            System.out.println("支线程"+i);
        }
    }
}

//可以看出 主线程 子线程并行交替执行

public class Main {
    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.start();
        for (int i=1;i<600;i++){
            System.out.println("主线程"+i);
        }
    }
}
