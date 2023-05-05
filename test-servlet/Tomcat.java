package org.apache;
import java.util.Scanner;
import java.io.FileReader;
import java.util.Properties;
import javax.servlet.Servlet;
public class Tomcat{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		System.out.println("Tomcat服务器启动成功");
		Scanner sc=new Scanner(System.in);
		String key=sc.nextLine();
		FileReader reader = new FileReader("web.properties");
		Properties pro=new Properties();
		pro.load(reader);
		reader.close();
		String className=pro.getProperty(key);
		Class clazz=Class.forName(className);
		Servlet obj=(Servlet)clazz.newInstance();
		obj.service();
	}	
}