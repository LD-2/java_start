package com.mirror.blob;

import com.mirror.util.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * @Description PreparedStatement可以操作Blob数据而Statement不可以
 *
 *
 */
public class BlobTest {
    //向数据表customers中插入Blob类型的字段
    @Test
    public void testInsert()throws Exception{
        Connection connection= JDBCUtils.getConnection();
        String sql="insert into customers(name,email,birth,photo)values(?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setObject(1,"ld");
        preparedStatement.setObject(2,"mirror@ld.com");
        preparedStatement.setObject(3,"2002-10-11");
        FileInputStream is=new FileInputStream(new File("mirror.jpg"));
        preparedStatement.setObject(4,is);
        preparedStatement.execute();
        JDBCUtils.closeResource(connection,preparedStatement);
    }

    //查询数据表customers中的Blob类型的字段
    @Test
    public void testQuery()throws Exception{
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        FileOutputStream fileOutputStream=null;
        InputStream is=null;
        try {
            connection=JDBCUtils.getConnection();
            String sql="select id,name,email,birth,photo from customers where id = ?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setObject(1,21);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                Object id = resultSet.getObject("id");
                Object name = resultSet.getObject("name");
                Object email = resultSet.getObject("email");
                Object birth = resultSet.getObject("birth");
                Blob photo = resultSet.getBlob("photo");
                is=photo.getBinaryStream();
                fileOutputStream = new FileOutputStream(new File("src/com/mirror/blob/mirror.jpg"));
                byte[] bs = new byte[1024];
                int len;
                while((len=is.read(bs))!=-1){
                    fileOutputStream.write(bs,0,len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is!=null){
                is.close();
            }
            if(fileOutputStream!=null){
                fileOutputStream.close();
            }
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
    }
}
