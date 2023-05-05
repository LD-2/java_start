package com.mirror.demo04;

import org.junit.Test;

import java.io.*;

public class InputOutput {
    @Test
    public void test() {
        InputStreamReader inputStreamReader=null;
        try {
            inputStreamReader=new InputStreamReader(new FileInputStream(new File("src/com/mirror/demo04/mirror.txt")),"UTF-8");
            char[] cs=new char[5];
            int len;
            while ((len=inputStreamReader.read(cs))!=-1){
    //            for (int i=0;i<len;i++){
    //                System.out.print(cs[i]);
    //            }
                String str=new String(cs,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStreamReader!=null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //InputStreamReader OutputStreamWriter
    @Test
    public void test02(){
        InputStreamReader inputStreamReader=null;
        OutputStreamWriter outputStreamWriter=null;
        try {
            inputStreamReader=new InputStreamReader(new FileInputStream(new File("src/com/mirror/demo04/mirror.txt")),"UTF-8");
            outputStreamWriter=new OutputStreamWriter(new FileOutputStream(new File("src/com/mirror/demo04/mirror2.txt")),"gbk");
            int len;
            char[] cs=new char[10];
            while((len=inputStreamReader.read(cs))!=-1){
                outputStreamWriter.write(cs,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStreamReader!=null){
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(outputStreamWriter!=null){
                    outputStreamWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            InputStream in = System.in;
        }
    }
}
