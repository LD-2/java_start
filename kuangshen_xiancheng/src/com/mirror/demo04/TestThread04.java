package com.mirror.demo04;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread04 implements Runnable {
    private String url;
    private String name;
    public TestThread04(String url, String name) {
        this.url = url;
        this.name=name;
    }

    @Override
    public void run() {
        Downloader d=new Downloader();
        d.f(url,name);
    }

    public static void main(String[] args) {
        new Thread(new TestThread04("https://img95.699pic.com/photo/50286/8851.jpg_wh300.jpg","1.jpg")).start();
        new Thread(new TestThread04("https://img95.699pic.com/photo/50349/1650.jpg_wh300.jpg","2.jpg")).start();
        new Thread(new TestThread04("https://i0.hdslb.com/bfs/archive/15f87e2621318dbb4b4047ffbd6e66805720cb49.jpg","3.jpg")).start();
    }
}
class Downloader{
    public void f(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        } finally {
            System.out.println("finally");
        }
    }
}
