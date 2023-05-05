package com.mirror.statement.curd;

import com.mirror.bean.Customer;
import com.mirror.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;

public class CustomerForQuery {
    /**
     * Customers表的通用查询
     *
     */
    @Test public void testCustomer(){
        String sql="select id,name,birth,email from customers where id = ?";
        Customer customer1=customerSelect(sql,19);
        System.out.println(customer1);

        String sql2="select id,email from customers where id = 19";
        Customer customer2=customerSelect(sql2);
        System.out.println(customer2);
        
    }
    public Customer customerSelect(String sql,Object...args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            //1、创建数据库的连接
            connection=JDBCUtils.getConnection();
            //2、预编译sql语句
            preparedStatement=connection.prepareStatement(sql);
            //3、填充占位符
            for(int i=0;i< args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            //4、执行sql
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int column=metaData.getColumnCount();
            if (resultSet.next()) {
                Customer member=new Customer();
                for (int i = 1; i <= column; i++) {
                    String name=metaData.getColumnName(i);
                    Object value=resultSet.getObject(i);
                    Field field=member.getClass().getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(member,value);
                }
                return member;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5、关闭资源
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }

    @Test
    public void test() throws SQLException, IOException, ClassNotFoundException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            //1、连接数据库
            connection=JDBCUtils.getConnection();
            //2、预编译sql语句
            String sql="select id,name,email,birth from `customers` where id = ?";
            preparedStatement=connection.prepareStatement(sql);
            //3、填充占位符
            preparedStatement.setObject(1,19);
            //4、执行
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {//查询下一调记录是否存在 存在继续下移找返回true  否则返回false    类似迭代器的hasnext 和 next方法
                int id=resultSet.getInt(1);
                String name = resultSet.getString("name");
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
                //返回数据显示:
                System.out.println("方式一: ");
                //方式一:
                System.out.println("id: "+id+"\nname: " + name + "\nemail: " + email + "\nbirth: " + birth);
                System.out.println("\n方式二: ");
                //方式二:
                Object[] data = new Object[]{id,name,email,birth};
                for(Object x:data){
                    System.out.println(x);
                }
                System.out.println("\n方式三: ");
                //方式三:
                Customer customer = new Customer(id,name,email,birth);
                System.out.println(customer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、关闭资源
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
    }
}
