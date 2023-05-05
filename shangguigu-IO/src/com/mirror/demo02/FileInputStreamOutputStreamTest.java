package com.mirror.demo02;

import org.junit.Test;

import java.io.*;

public class FileInputStreamOutputStreamTest {
    @Test
    public void test() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //1、创建需要读写操作的文件
            File file=new File("src/com/mirror/demo02/mirror.jpg");
            File copyFile=new File("src/com/mirror/demo02/copy-mirror.jpg");
//        System.out.println(file.exists());
            //2、根据需要操作的文件类型和读写操作 创建对应的流对象
            fileInputStream=new FileInputStream(file);
            fileOutputStream=new FileOutputStream(copyFile);
            //3、对文件进行操作 拷贝一个mirror.jpg图片
            byte[] bs=new byte[1024];
            int len;
            while ((len=fileInputStream.read(bs))!=-1){
                fileOutputStream.write(bs,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4、关闭流
            try {
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileInputStream!=null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    @Test
    public void test02(){
        long start =System.currentTimeMillis();
        String str1="src/com/mirror/demo02/twitch插件详细讲解.mp4";
        String str2="src/com/mirror/demo02/twitch插件详细讲解copy.mp4";
        copy(str1,str2);
        long end=System.currentTimeMillis();
        System.out.println("复制所使用的时间: "+(end-start)+"ms");
    }
    //文件的复制方法
    public void copy(String str1,String str2) {
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream=new FileInputStream(str1);
            fileOutputStream=new FileOutputStream(str2);
            byte[] bs=new byte[1024];
            int len;
            while((len=fileInputStream.read(bs))!=-1) {
                fileOutputStream.write(bs, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileInputStream!=null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
