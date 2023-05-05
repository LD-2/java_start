package com.mirror.demo13;


//多个线程互相拿着对方的资源 然后形成僵直
public class DeadLock {
    public static void main(String[] args) {
        MakeUp t1=new MakeUp(0,"mirror");
        MakeUp t2=new MakeUp(1,"ld");
        t1.start();
        t2.start();
    }
}
class Lipstick{

}
class Mirror{

}

class MakeUp extends Thread{
    //需要的资源只有一份 用static保证只有一份
    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();
    int choice;
    String name;

    public MakeUp(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        this.makeup();
    }
    private void makeup(){
        if(choice==0) {
            synchronized (lipstick) {
                System.out.println(name+"获得口红锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(mirror){
                    System.out.println(name+"获得镜子锁");
                };
            }
        }
        else {
            synchronized (mirror){
                System.out.println(name+"获得镜子锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(lipstick){
                    System.out.println(name+"获得口红锁");
                }
            }
        }
    }
}
