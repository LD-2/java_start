package com.mirror;
import org.junit.Assert;
import org.junit.Test;
public class TestHelloMaven {
	@Test
	public void testAdd(){
		HelloMaven hello = new HelloMaven();
		int res=hello.add(10,20);
		//assertEquals(期望值 , 实际值);
		Assert.assertEquals(30,res);
	}
}