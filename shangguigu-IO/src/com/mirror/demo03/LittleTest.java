package com.mirror.demo03;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LittleTest {
    @Test
    public void test(){
        BufferedInputStream inputStream=null;
        BufferedOutputStream outputStream=null;
        try {
//            inputStream = new BufferedInputStream(new FileInputStream(new File("src/com/mirror/demo03/mirror.jpg")));
//            outputStream = new BufferedOutputStream(new FileOutputStream(new File("src/com/mirror/demo03/new-mirror.jpg")));
            inputStream = new BufferedInputStream(new FileInputStream(new File("src/com/mirror/demo03/new-mirror.jpg")));
            outputStream = new BufferedOutputStream(new FileOutputStream(new File("src/com/mirror/demo03/new-mirror-jie.jpg")));
            byte[] bs=new byte[1024];
            int len;
            while ((len=inputStream.read(bs))!=-1){
                for (int i=0;i<len;i++){
                    bs[i]=(byte)(bs[i]^5);
                }
                outputStream.write(bs,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(outputStream!=null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test02(){
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("src/com/mirror/demo03/mirror.txt")));
            bufferedWriter=new BufferedWriter(new FileWriter(new File("src/com/mirror/demo03/new-mirror.txt")));
            Map<Character, Integer> map=new HashMap<Character, Integer>();
            int i;
            while ((i=bufferedReader.read())!=-1){
                char c=(char)i;
                if(map.get(c)==null){
                    map.put(c,1);
                }
                else{
                    map.put(c,map.get(c)+1);
                }
            }
            Set<Map.Entry<Character, Integer>> entrySet=map.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                bufferedWriter.write(entry.getKey()+": "+entry.getValue()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedWriter!=null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
