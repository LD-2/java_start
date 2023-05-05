package com.mirror.servlet;

import com.mirror.bean.Customer;
import jakarta.servlet.*;

import java.io.*;
import java.sql.*;

public class CustomersServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        FileOutputStream fileOutputStream=null;
        InputStream binaryStream=null;
        try {
            servletResponse.setContentType("text/html");
            PrintWriter out = servletResponse.getWriter();
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/mirror?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
            String user="root";
            String password="123456";
            connection = DriverManager.getConnection(url,user,password);
            String sql="select id,name,email,birth,photo from customers where id = ?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setObject(1,21);
            resultSet= preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
                binaryStream = resultSet.getBlob(5).getBinaryStream();
                fileOutputStream = new FileOutputStream(new File("E:\\java-projects\\idea-projects\\servlet01\\web\\images\\mirror.jpg"));
                int len;
                byte[] bytes = new byte[1024];
                while ((len = binaryStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, len);
                }
                Customer customer = new Customer(id, name, email, birth);
                System.out.println("控制台输出: " + customer);
                out.print("<h1>My First Servlet!</h1>");
                out.print(customer + "<br/>");
                out.print("这里不知道图片文件路径的设立 有点迷 <br/>");
                out.print("<img src=\"ld/images/mirror.jpg\" width=\"200px\" height=\"200px\" alt=\"MyIcon\">");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(binaryStream!=null) {
                binaryStream.close();
            }
            if(fileOutputStream!=null) {
                fileOutputStream.close();
            }
            try {
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(resultSet!=null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
