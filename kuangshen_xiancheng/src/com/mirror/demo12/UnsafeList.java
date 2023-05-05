package com.mirror.demo12;
import java.util.ArrayList;
import java.util.List;
//线程不安全的集合
//ArrayList就不安全
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println(list.size());
        //可能两个线程操作的一瞬间 添加到了一个数组中 所以就会出现 数组数变小的问题
    }
}
