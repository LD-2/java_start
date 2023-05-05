package com.mirror.action;

import com.mirror.utils.JDBCUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno = req.getParameter("deptno");
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");
        resp.setContentType("text/html;charset=utf-8");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int count=0;
        try {
            connection= JDBCUtils.getConnection2();
            String sql="update dept set dname=?,loc=? where deptno=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,dname);
            preparedStatement.setString(2,loc);
            preparedStatement.setString(3,deptno);
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,preparedStatement,null);
        }
        if(count==0){
//            req.getRequestDispatcher("/html/error.html").forward(req,resp);
            resp.sendRedirect("/oa/html/error.html");
        }else{
//            req.getRequestDispatcher("/ldMirror/ListServlet").forward(req,resp);
            resp.sendRedirect("/oa/ldMirror/ListServlet");
        }
    }
}
