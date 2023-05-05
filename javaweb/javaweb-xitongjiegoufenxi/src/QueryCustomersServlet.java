package com.mirror.servlet;
//import  com.mirror.bean.Customer;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletConfig;

import java.io.*;
import java.sql.*;

public class QueryCustomersServlet implements Servlet{
    public void init(ServletConfig config) throws ServletException{

    }
    public ServletConfig getServletConfig(){
        return null;
    }
    public void	destroy(){

    }
    public String getServletInfo(){
        return "";
    }
    public void	service(ServletRequest req, ServletResponse res) throws IOException{
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        FileOutputStream fileOutputStream=null;
        InputStream binaryStream=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/mirror?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
            String user="root";
            String password="123456";
            connection= DriverManager.getConnection(url,user,password);
            String sql="select id,name,email,birth,photo from customers where id=?";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setObject(1,21);
            resultSet=preparedStatement.executeQuery();
//            ResultSetMetaData metaData = resultSet.getMetaData();
            if(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
                binaryStream = resultSet.getBlob(5).getBinaryStream();
                fileOutputStream = new FileOutputStream(new File("E:\\java-projects\\package\\apache-tomcat-10.0.27\\webapps\\crm\\images\\mirror.jpg"));
                int len;
                byte[] bytes = new byte[1024];
                while((len=binaryStream.read(bytes))!=-1){
                    fileOutputStream.write(bytes,0,len);
                }
//                Customer customer=new Customer(id,name,email,birth);
                System.out.println(id+" "+name+" "+email+" "+birth);
                out.println("<h1>My First Servlet..</h2>");
                out.println("<img src=\"/crm/images/mirror.jpg\" alt=\"MyIcon\" width=\"200px\" height=\"200px\"></img>");
//                out.println(customer);
                out.println("<br/>");
                out.print(id+"<br/>");
                out.print(name+"<br/>");
                out.print(email+"<br/>");
                out.print(birth+"<br/>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(binaryStream!=null){
                    binaryStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(preparedStatement!=null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(resultSet!=null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
