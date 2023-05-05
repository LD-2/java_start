package com.mirror.action;

import com.mirror.utils.JDBCUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno = req.getParameter("deptno");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int count=0;
        try {
            String sql="delete from dept where deptno=?";
            connection=JDBCUtils.getConnection2();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,deptno);
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
            //请求还是一个  因此上面地址栏还是显示deleteServlet的路径资源

            resp.sendRedirect("/oa/ldMirror/ListServlet");
        }
    }
}
