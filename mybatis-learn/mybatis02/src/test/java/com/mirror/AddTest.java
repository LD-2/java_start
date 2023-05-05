package com.mirror;

import org.junit.Assert;
import org.junit.Test;

public class AddTest {
    @Test
    public void addTest(){
        Add addObj = new Add();
        int result = addObj.add(20, 30);
        Assert.assertEquals(50,result);
        System.out.println("测试成功");
    }
}
