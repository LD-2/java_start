package com.mirror.demo05;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class GoodTest02 {
    @Test
    public void test() throws FileNotFoundException {
        PrintStream ps=null;
        FileOutputStream out = new FileOutputStream(new File("src/com/mirror/demo05/mirror.txt"));
        ps=new PrintStream(out,true);
        if(ps!=null){
            System.setOut(ps);
        }
        for(int i=0;i<=255;i++){
            System.out.println((char)i);
        }
        ps.close();
    }
}
