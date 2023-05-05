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

public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;utf-8");
        PrintWriter writer = resp.getWriter();

        Connection connection=null;
        PreparedStatement preparedStatement=null;

        String deptno = req.getParameter("deptno");
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");
        int count=0;
        try {
            connection= JDBCUtils.getConnection2();
            String sql="insert into dept (deptno,dname,loc)values (?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, deptno);
            preparedStatement.setString(2,dname);
            preparedStatement.setString(3,loc);
            count = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,preparedStatement,null);
        }
        System.out.println(count);
        if(count==0){
//            req.getRequestDispatcher("/html/error.html").forward(req,resp);
            resp.sendRedirect("/oa/html/error.html");
        }
        else {

//            req.getRequestDispatcher("/ldMirror/ListServlet").forward(req,resp);


            writer.println("<script type='text/JavaScript'>");
            writer.println("if(window.confirm('添加成功')){");
            writer.println("document.location.href='/oa/ldMirror/ListServlet';");
            writer.println("}");
            writer.println("else");
            writer.println("{");
            writer.println("document.location.href='/oa/ldMirror/ListServlet';");
            writer.println("}");
//            req.getRequestDispatcher("/ldMirror/ListServlet").forward(req,resp);
            writer.println("</script>");
        }
    }
}
