package com.mirror;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Test {
    @Test
    public void testGetConnection() throws PropertyVetoException, SQLException {

        //方式一:
        //获取c3p0数据库连接池
        ComboPooledDataSource cpds=new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/mirror");
        cpds.setUser("root");
        cpds.setPassword("123456");
        //通过设置相关参数 对数据库连接池 进行管理
        //设置初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);
        Connection connection=cpds.getConnection();
        System.out.println(connection);

    }

    @Test
    public void test02() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("hello-c3p0");
        Connection connection = cpds.getConnection();
        System.out.println(connection);
    }
}
