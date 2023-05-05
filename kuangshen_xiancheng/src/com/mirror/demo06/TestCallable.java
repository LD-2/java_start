package com.mirror.demo06;
//线程创建方式三:  实现callable接口

import com.mirror.demo02.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable implements Callable<String> {
    private String url;
    private String name;
    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Download d=new Download();
        d.f(url, name);
        return this.name;
    }

    public static void main(String[] args) {
        TestCallable t1=new TestCallable("https://img95.699pic.com/photo/50286/8851.jpg_wh300.jpg","image1.jpg");
        TestCallable t2=new TestCallable("https://img95.699pic.com/photo/50349/1650.jpg_wh300.jpg","image2.jpg");
        TestCallable t3=new TestCallable("https://i0.hdslb.com/bfs/archive/15f87e2621318dbb4b4047ffbd6e66805720cb49.jpg","image3.jpg");
        //创建执行服务:
        ExecutorService ser= Executors.newFixedThreadPool(3);

        //提交执行
        Future<String> r1=ser.submit(t1);
        Future<String> r2=ser.submit(t2);
        Future<String> r3=ser.submit(t3);

        //获取结果
        String rs1=r1.toString();
        String rs2=r2.toString();
        String rs3=r3.toString();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        ser.shutdownNow();

    }
}
class Download{
    public void f(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}
