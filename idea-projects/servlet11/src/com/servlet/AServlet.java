package com.servlet;

import com.utils.JDBCUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String no = req.getParameter("no");
        String name = req.getParameter("name");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int count=0;
        try {
            connection= JDBCUtils.getConnection2();
            String sql="insert  into student(no,name)values(?,?)";
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,no);
            preparedStatement.setString(2,name);
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,preparedStatement,null);
        }
        if(count==0){
            resp.sendRedirect("/servlet11/warn.html");
        }else {
//            resp.sendRedirect("/servlet11/success.html");
            req.getRequestDispatcher("/success.html").forward(req,resp);
        }
    }
}
