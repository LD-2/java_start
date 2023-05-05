package com.mirror.demo02;

import org.junit.Test;

import java.io.*;

public class BufferedTest {
    @Test
    public void test() {
        long start=System.currentTimeMillis();
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try {
            //1、创建要操作的文件对象
            File file=new File("src/com/mirror/demo02/twitch插件详细讲解.mp4");
            File copyFile=new File("src/com/mirror/demo02/copy-twitch插件详细讲解.mp4");
            //2、根据流的流向 和操作文件类型 创建对应的流
            //2.1 造节点流
            FileInputStream fileInputStream=new FileInputStream(file);
            FileOutputStream fileOutputStream=new FileOutputStream(copyFile);
            //2.2 造缓冲流
            bufferedInputStream=new BufferedInputStream(fileInputStream);
            bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            //3、开始操作数据
            byte[] bs=new byte[1024];
            int len;
            while((len=bufferedInputStream.read(bs))!=-1){
                bufferedOutputStream.write(bs,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流 顺序 先关闭外层的再关闭内层的 外层关闭的方法中已经有关闭内层的方法 因此 不用写关闭内层的方法
            try {
                if(bufferedInputStream!=null){
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedOutputStream!=null){
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start+"ms");
    }


    //方法练习
    public void copy(String str1,String str2) {
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try {
            bufferedInputStream=new BufferedInputStream(new FileInputStream(new File(str1)));
            bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(new File(str2)));
            byte[] bs=new byte[1024];
            int len;
            while((len=bufferedInputStream.read(bs))!=-1){
                bufferedOutputStream.write(bs,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedInputStream!=null){
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedOutputStream!=null){
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test02(){
        String str1="src/com/mirror/demo02/twitch插件详细讲解.mp4";
        String str2="src/com/mirror/demo02/copy-twitch插件详细讲解02.mp4";
        copy(str1,str2);
    }

    @Test
    public void testBufferedReaderWriter() throws IOException {
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("src/com/mirror/demo02/mirror.txt")));
            bufferedWriter=new BufferedWriter(new FileWriter(new File("src/com/mirror/demo02/copy-mirror.txt")));
            //新的读取方式
            String data;
            while ((data=bufferedReader.readLine())!=null){
//                //方式一:
//                bufferedWriter.write(data+"\n");//默认没有读取换行
                //方式二:
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader!=null){
                bufferedReader.close();
            }
            if(bufferedWriter!=null){
                bufferedWriter.close();
            }
        }
    }
}
