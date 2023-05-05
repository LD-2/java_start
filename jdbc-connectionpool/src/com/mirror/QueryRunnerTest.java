package com.mirror;

import com.bean.Customer;
import com.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class QueryRunnerTest {

    //测试插入
    @Test
    public void insertTest(){
        Connection connection=null;
        try {
            connection= JDBCUtils.getConnection3();
            String sql="insert into customers(name,email,birth)values(?,?,?)";
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date date=sdf.parse("2002-10-24");
            int insertCount = new QueryRunner().update(connection, sql, "girl", "69.com", new java.sql.Date(date.getTime()));
            System.out.println("成功添加了 "+insertCount+" 条记录.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    //测试查询
    @Test
    public void queryTest() {
        Connection connection=null;
        try {
            connection=JDBCUtils.getConnection3();
            QueryRunner queryRunner = new QueryRunner();
            //查询单个-方式一:
//            String sql="select id,name,email,birth from customers where id=?";
//            BeanHandler<? extends Customer> beanHandler = new BeanHandler<>(new Customer().getClass());
//            Customer query = queryRunner.query(connection, sql, beanHandler, 21);
//            System.out.println(query);
            //查询多个-方式一:
//            String sql="select id,name,email,birth from customers where id<12";
//            BeanListHandler<Customer> customerBeanListHandler = new BeanListHandler<>(new Customer().getClass());
//            List<Customer> query = queryRunner.query(connection, sql, customerBeanListHandler);
//            query.forEach(System.out::println);
            //查询单个-方式二:
//            String sql="select id,name,email,birth from customers where id=?";
//            MapHandler mapHandler = new MapHandler();
//            Map<String, Object> query = queryRunner.query(connection, sql, mapHandler, 12);
//            System.out.println(query);
            //查询多个-方式二:
//            String sql="select id,name,email,birth from customers where id<?";
//            MapListHandler mapListHandler = new MapListHandler();
//            List<Map<String, Object>> listQuery = queryRunner.query(connection, sql, mapListHandler, 12);
//            for (Map<String, Object> stringObjectMap : listQuery) {
//                System.out.println(stringObjectMap);
//            }
            //特殊值的查询:
//            String sql="select count(*) from customers";
//            ScalarHandler<Long> customerScalarHandler = new ScalarHandler<>();
//            Long query = queryRunner.query(connection, sql, customerScalarHandler);
//            System.out.println(query);
            //自定义的Handler
            ResultSetHandler resultSetHandler=new ResultSetHandler(){
                @Override
                public Object handle(ResultSet resultSet) throws SQLException {
                    System.out.println("自定义的");
                    return null;
                }
            };
            String sql="select id,name,email,birth from customers where id=?";
            Object query = queryRunner.query(connection, sql, resultSetHandler, 12);
            System.out.println(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
