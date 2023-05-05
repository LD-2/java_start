package com.mirror;


import org.junit.Assert;
import org.junit.Test;

public class TestHelloMaven {
    @Test
    public void testAdd(){
        HelloMaven hello = new HelloMaven();
        int res=hello.add(10,20);
        Assert.assertEquals(30,res);
    }

    @Test
    public void testAdd2(){
        HelloMaven hello = new HelloMaven();
        int res=hello.add(20,20);
        Assert.assertEquals(40,res);
    }
}
