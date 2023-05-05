package com.mirror.demo09;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时 打印当前系统时间
public class TestSleep03 {
    public static void main(String[] args) {
        Date startTime=new Date(System.currentTimeMillis());//获取系统当前时间
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime=new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}
