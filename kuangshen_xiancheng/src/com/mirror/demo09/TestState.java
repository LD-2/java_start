package com.mirror.demo09;

//观察线程状态
public class TestState {
    public static void main(String[] args) throws Exception {
        Thread thread=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////////");
        });

        //观察状态
        Thread.State state=thread.getState();
        System.out.println(state); //New 新生

        thread.start();
        state=thread.getState();
        System.out.println(state); //RUN 就绪

        while(state!=Thread.State.TERMINATED){
            Thread.sleep(100);// 阻塞状态
            state=thread.getState();
            System.out.println(state);
        }
    }
}
