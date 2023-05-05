package com.mirror.preparedstatement;
/*

使用preparedStatement替换statement
增删改  查

*/


import com.mirror.util.JDBCUtils;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static com.mirror.util.JDBCUtils.closeResource;
import static com.mirror.util.JDBCUtils.getConnection;

public class PreparedStatementUpdateTest {

    @Test
    public void test(){
//        String sql="Delete from customers where id = ?";
//        update(sql,3);
        //数据库的命名冲突
        String sql="update `order` set order_name = ? where order_id = ?";
        update(sql,"JJ",4);
    }
    //通用的增删改操作
    public void update(String sql,Object ...args) {
        //传入多个参数
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            //1、连接数据库
            connection=JDBCUtils.getConnection();
            //2、预编译sql语句
            preparedStatement = connection.prepareStatement(sql);
            //3、分配占位符
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            //4、执行
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、关闭资源
            JDBCUtils.closeResource(connection,preparedStatement);
        }
    }



    //修改customers表的一条记录
    @Test
    public void testUpdate() {
        Connection connection= null;
        PreparedStatement preparedStatement= null;
        try {
            //1、连接数据库
            connection = getConnection();
            //2、预编译sql语句
            String sql="update customers set name = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            //3、填充占位符
            preparedStatement.setObject(1,"贾娃");
            preparedStatement.setObject(2,18);
            //4、执行sql语句
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、关闭资源
            closeResource(connection,preparedStatement);
        }

    }


    //向customers表中添加一条数据
    @Test
    public void testInsert() throws IOException, ClassNotFoundException, SQLException, ParseException {
        PreparedStatement preparedStatement = null;
        Connection connection=null;
        try {
            //首先连接数据库
            InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties=new Properties();
            properties.load(resourceAsStream);
            String url = properties.getProperty("url");
            String user=properties.getProperty("user");
            String password=properties.getProperty("password");
            String driverClass=properties.getProperty("driverClass");
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);


            //2、预编译sql语句 返回PreparedStatement的实例
            //获取一个preparedStatement的实例
            String sql="insert into customers(name,email,birth)values(?,?,?)";//?占位符
            //这里是驱动实现了Connection接口  Connection接口中有PrepareStatement的方法 PrepareStatement继承了Statement接口
            preparedStatement = connection.prepareStatement(sql);

            //填充占位符
            preparedStatement.setString(1,"mirror");
            preparedStatement.setString(2,"1392556557@qq.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date
            Date date=sdf.parse("2002-10-23");
            preparedStatement.setDate(3,new java.sql.Date(date.getTime()));

            //执行Sql
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            try {
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
