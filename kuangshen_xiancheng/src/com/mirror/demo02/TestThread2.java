package com.mirror.demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestThread2 extends Thread {
    private String name;
    private String url;
    public TestThread2(String url,String name){
        this.name=name;
        this.url=url;
    }

    @Override
    public void run() {
        WebDownloader download=new WebDownloader();
        download.download(url,name);
        System.out.println(name+"");
    }

    public static void main(String[] args) {
        TestThread2 t1=new TestThread2("https://img95.699pic.com/photo/50286/8851.jpg_wh300.jpg","first.jpg");
        TestThread2 t2=new TestThread2("https://img95.699pic.com/photo/50349/1650.jpg_wh300.jpg","second.jpg");
        TestThread2 t3=new TestThread2("https://i0.hdslb.com/bfs/archive/15f87e2621318dbb4b4047ffbd6e66805720cb49.jpg","third.jpg");
        t1.start();
        t2.start();
        t3.start();
    }
}
//下载器
class WebDownloader{
    public void download(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        } finally {
            System.out.println("Finally");
        }
    }
}
