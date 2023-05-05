package com.mirror.demo05;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodTest {
    @Test
    public void test(){
        BufferedReader bufferedReader=null;
        try {
            InputStreamReader inputStreamReader=new InputStreamReader(System.in);
            bufferedReader=new BufferedReader(inputStreamReader);

            while(true){
                String data= bufferedReader.readLine();
                if("e".equalsIgnoreCase(data)||"exit".equalsIgnoreCase(data)){
                    break;
                }
                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
