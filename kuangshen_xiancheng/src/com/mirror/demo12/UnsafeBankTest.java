package com.mirror.demo12;

public class UnsafeBankTest {
    public static void main(String[] args) {
        Account account=new Account(100,"农业银行");
        Drawing mirror = new Drawing(account,50,"mirror");
        Drawing ld=new Drawing(account,100,"ld");
//        mirror.start();
//        System.out.println();
//        ld.start();
//
//        new Thread(mirror).start();
//        new Thread(ld).start();

        mirror.start();
        System.out.println();
        ld.start();
    }
}

//账户
class Account {
    private String name;
    private int money;
    public Account(int money,String name) {
        this.money=money;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void Drawing(int drawingMoney){
        this.money=this.money-drawingMoney;
    }

    public void Saving(int savingMoney){
        this.money=this.money+savingMoney;
    }
}
class Drawing extends Thread{
    private Account account;
    private int drawingMoney;
    private int nowMoney;
    public Drawing(Account account,int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
        this.nowMoney=0;
    }

    //synchronized默认锁的是this对象本身
    @Override
    public void run() {
        synchronized(account) {
            if (account.getMoney() <= 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够了！");
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.Drawing(drawingMoney);
                nowMoney = drawingMoney + nowMoney;
                System.out.println(account.getName() + " 余额为: " + account.getMoney());
                System.out.println(this.getName() + " 手里的钱 " + nowMoney);
            }
        }
    }
}
