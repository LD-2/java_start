package com.mirror.demo01;

import org.junit.Test;

import java.io.*;

/**
 * 流的分类:
 * 1、操作的数据单位: 字节流 字符流
 * 2、数据的流向: 输入流 输出流
 * 3、流的角色: 节点流 处理流
 *
 *
 * 流的体系结构:
 * 抽象基类: InputStream OutStream Reader Writer
 * 节点流（文件流）: FileInputStream FileOutputStream FileReader FileWriter
 * 缓冲流(处理流的一种): BufferedInputStream BufferedOutputStream BufferedReader BufferedWriter
 *
 *
 * 基本概念：File类是文件和目录路径名的抽象表示形式，代表文件或者文件夹。并且 File无法对其所表示文件内容进行任何读写操作（那是流做的事情）
 */
public class FileReaderWriterTest {

    //读取mirror.txt文件中的内容输出到控制台
    @Test
    public void test01() {
//        File file = new File("src/com/mirror/demo01/mirror.txt");
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.exists());

        FileReader fileReader=null;
        try {
            //1、创建File类对象 指明要操作的对象
            File file=new File("src/com/mirror/demo01/mirror.txt");
            //2、因为是文本数据所以创建字符流  提供具体的流 文件字符流
            fileReader=new FileReader(file);
            //3、数据的读入
            int res;
            while((res=fileReader.read())!=-1){
                System.out.print((char)res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader!=null){
                    //4、流的关闭
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    //对read()操作的升级 使用read()重载方法
    @Test
    public void test02() {
        FileReader fileReader=null;
        try {
            //1、创建File类 指定需要读取的文件
            File file=new File("src/com/mirror/demo01/mirror.txt");
//        System.out.println(file.exists());
            //2、选择指定的流对接数据
            fileReader=new FileReader(file);
            char[] chars=new char[5];
            int res;
            while((res = fileReader.read(chars))!=-1){
    //            for(int i=0;i<res;i++){
    //                System.out.print(chars[i]);
    //            }
                String str=new String(chars,0,res);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader!=null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //从内存中写出数据到硬盘的文件中
    //1、输出操作 对应的File文件可以不存在 如果不存在 在输出的过程中会自动创建此文件 因此不会报异常
    //2、如果存在 根据第二个参数append判断是否 对原有的文件覆盖 或者添加   流构造器FileWriter(file,false)  FileWriter(file,true) 默认false
    @Test
    public void test03() {
        FileWriter writer=null;
        try {
            //1、创建文件类 指明读出的文件名
            File file=new File("src/com/mirror/demo01/ld.txt");
            //2、根据流向和数据类型以及文件类型 创建对应的流 传输数据
            writer=new FileWriter(file,true);
            //3、传输数据
            writer.write("I'm ld.\n");
            writer.write("My brother is mirror !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer!=null) {
                    //4、关闭流
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //文件的写入 读出操作
    //好吧 暂时还不知道怎么同时读写操作一个文件
    @Test
    public void test04() throws IOException {
        //1、文件的创建 指定操作对象
        File file=new File("src/com/mirror/demo01/mirror.txt");
//        File file=new File("src/com/mirror/demo01/ld.txt");
        //2、根据 流向和数据类型 创建指定的对象 调用相应的API操作数据
        FileWriter fileWriter=new FileWriter(file,true);
        FileReader fileReader=new FileReader(file);
        //3、操作数据
        fileWriter.write("\nMy brother is ld !");
        fileWriter.close();
        char[] cs=new char[6];
        int count;
        while ((count=fileReader.read(cs))!=-1){
            for(int i=0;i<count;i++){
                System.out.print(cs[i]);
            }
        }
        fileReader.close();
    }

    //文件内容的拷贝复制
    @Test
    public void test05() {
        FileWriter fileWriter= null;
        FileReader fileReader= null;
        try {
            //1、创建文件对象 指定需要操作的文件对象
            File file = new File("src/com/mirror/demo01/mirror.txt");
            File copyFile=new File("src/com/mirror/demo01/copy-mirror.txt");
            //2、根据 输入输出和操作数据的类型 创建对应的流 操作数据
            fileWriter = new FileWriter(copyFile);
            fileReader = new FileReader(file);
            //3、操作数据
            char[] cs=new char[5];
            int count;
            while((count=fileReader.read(cs))!=-1){
                fileWriter.write(cs,0,count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(fileReader!=null)
                //4、关闭资源
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileWriter!=null)
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
