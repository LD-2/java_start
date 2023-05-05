package com.mirror.demo09;

public class TestStop implements Runnable{
    private boolean flag=true;
    @Override
    public void run() {
        int idx=0;
        while(flag){
            System.out.println("子线程 "+idx++);
        }
    }
    public void stop(){
        this.flag=false;
    }
    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for(int i=1;i<=1000;i++){
            if(i==900){
                testStop.stop();
            }
            System.out.println("主线程 "+i);
        }
    }
}
