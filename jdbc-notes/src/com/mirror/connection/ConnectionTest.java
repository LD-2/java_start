package com.mirror.connection;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
    //获取数据库的连接 方式一:
    @Test
    public void test01() throws SQLException {
//        Driver driver=null;
        //这里是mysql数据库实现的接口
        Driver driver=new com.mysql.cj.jdbc.Driver();
//        String url=null;
        String url="jdbc:mysql://localhost:3306/mirror?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
//        Properties info=null;
        //这里把用户名和密码封装到了Properties
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");
        Connection connection=driver.connect(url,info);
        System.out.println(connection);
    }

    //获取数据库的连接 方式二:  不希望源码中出现过多的修改
    @Test
    public void test02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException {
        //1、获取Driver对象
        Class clazz=Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver=(Driver)clazz.newInstance();
        //这里反射机制搞出来以后还是com.mysql.cj.jdbc.Driver的对象
//        Constructor constructor=clazz.getDeclaredConstructor();
//        Driver driver=(Driver) constructor.newInstance();
//        System.out.println(clazz);
        //2、提供需要连接的数据库
        String url ="jdbc:mysql://localhost:3306/mirror?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        //3、提供需要连接的用户名和密码
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");
        //4、进行连接
        Connection connection= driver.connect(url,info);
        System.out.println(connection);
    }

    //创建数据库的连接 方式三: 使用DriverManager替换Driver
    @Test
    public void test03() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz=Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver=(Driver)clazz.newInstance();
        //导入驱动
        DriverManager.registerDriver(driver);
        //设置连接数据库信息
        String url="jdbc:mysql://localhost:3306/mirror?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");
        String user="root";
        String password="123456";
        //获取连接
        Connection connection01=DriverManager.getConnection(url,info);
        Connection connection02=DriverManager.getConnection(url,user,password);
        System.out.println(connection01);
        System.out.println(connection02);
    }

    //创建数据库的连接方式4: 可以是只加载驱动 不再显示注册驱动 因为这里在加载驱动的类的时候 会执行此类中的静态代码块 静态代码块里有DriverManager这个类的驱动载入
    @Test
    public void test04() throws ClassNotFoundException, SQLException {
        //1、创建连接需要的信息
        String url="jdbc:mysql://localhost:3306/mirror?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String user="root";
        String password="123456";
        //2、加载Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3、创建连接
        Connection connection=DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }

    //读取配置文件信息方法
    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        //读取配置文件方式一
        //此时读取文件默认在当前的module下
//        FileInputStream fis=new FileInputStream("src\\jdbc.properties");
//        properties.load(fis);

        //读取配置文件方式二
        //此时读取文件默认在当前的module下的src下  在部署tomcat的时候要记得配置信息在src下不然读不到
        ClassLoader classloader=ConnectionTest.class.getClassLoader();
        InputStream resourceAsStream = classloader.getResourceAsStream("jdbc.properties");
        properties.load(resourceAsStream);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url=properties.getProperty("url");
        System.out.println("user : "+user+"\npassword : "+password+"\nurl : "+url);
    }

    //创建数据库的连接方式5:  配置信息一般不要以硬编码的方式写到 代码中 应该将配置信息写到配置文件中 然后去读取配置文件中的信息
    //实现此方法的好处:
    //1、实现了数据和代码的分离  实现了解耦
    //2、如果需要修改配置信息 可以避免程序重新打包
    @Test
    public void test05() throws IOException, SQLException, ClassNotFoundException {
        //读取配置文件中的四个信息
        Properties properties = new Properties();
        ClassLoader classloader=ClassLoader.getSystemClassLoader();
        InputStream resourceAsStream = classloader.getResourceAsStream("jdbc.properties");
        properties.load(resourceAsStream);
        String url=properties.getProperty("url");
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String driverClass=properties.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);

        //导入信息 创建连接
        Connection connection=DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }

}
