package com.mirror;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPTest {

    //方式一:
    @Test
    public void test() throws SQLException {
        //创建dbcp数据库连接池
        BasicDataSource source = new BasicDataSource();
        //设置基本信息
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql:///mirror");
        source.setUsername("root");
        source.setPassword("123456");

        source.setInitialSize(10);
        source.setMaxIdle(10);
        source.setMaxTotal(10);
        Connection connection=source.getConnection();
        System.out.println(connection);
    }

    //方式二: 使用配置文件
    @Test
    public void test02() throws Exception {
        Properties properties = new Properties();
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        properties.load(resourceAsStream);
        BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

}
