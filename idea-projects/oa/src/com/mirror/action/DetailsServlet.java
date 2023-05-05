package com.mirror.action;

import com.mirror.utils.JDBCUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String deptno = req.getParameter("deptno");

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("");
        writer.println("<head lang='zh-CN'>");
        writer.println("    <meta charset='UTF-8'>");
        writer.println("    <title>详情</title>");
        writer.println("</head>");
        writer.println("");
        writer.println("<body>");

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
            connection = JDBCUtils.getConnection2();
            String sql="select deptno,dname,loc from dept where deptno=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, deptno);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int no = resultSet.getInt("deptno");
                String dname=resultSet.getString("dname");
                String loc=resultSet.getString("loc");
                writer.println("    <h3>详情</h3>");
                writer.println("        "+ no +" --------部门编号<br>");
                writer.println("        "+ dname +" ------部门名称<br>");
                writer.println("        "+ loc +"-------地理位置<br>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,preparedStatement,resultSet);
        }

        writer.println("   <input type='button' value='后退' onclick='window.history.back()'>");
        writer.println("</body>");
        writer.println("");
        writer.println("</html>");
    }
}
