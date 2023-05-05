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

public class UpdateShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String deptno = req.getParameter("deptno");
        String contextPath = req.getContextPath();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        writer.println("        <!DOCTYPE html>");
        writer.println("<html lang='zh-CN'>");
        writer.println("");
        writer.println("<head>");
        writer.println("    <meta charset='UTF-8'>");
        writer.println("    <title>修改</title>");
        writer.println("    <link rel='stylesheet' href='"+ contextPath +"/css/update.css'>");
        writer.println("</head>");
        writer.println("");
        writer.println("<body>");
        writer.println("    <div class='container'>");
        writer.println("        <div class='update-box'>");
        writer.println("            <h2>Update</h2>");
        writer.println("            <form action='"+ contextPath +"/ldMirror/UpdateServlet' method='post'>");

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection=JDBCUtils.getConnection2();
            String sql="select deptno,dname,loc from dept where deptno=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,deptno);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                int dno = resultSet.getInt("deptno");
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");
                writer.println("                <div class='row'>");
                writer.println("                    <input type='text' id='dno' value='"+ dno +"' readonly name='deptno'>");
                writer.println("                    <label for='dno'>部门编号</label>");
                writer.println("                </div>");
                writer.println("                <div class='row'>");
                writer.println("                    <input type='text' id='dna' value='"+ dname +"' name='dname'>");
                writer.println("                    <label for='dna'>部门名称</label>");
                writer.println("                </div>");
                writer.println("                <div class='row'>");
                writer.println("                    <input type='text' id='lc' value='"+ loc +"'name=loc>");
                writer.println("                    <label for='lc'>地理位置</label>");
                writer.println("                </div>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,preparedStatement,resultSet);
        }

        writer.println("                <div class='sb'>");
        writer.println("                    <span></span>");
        writer.println("                    <span></span>");
        writer.println("                    <span></span>");
        writer.println("                    <span></span>");
        writer.println("                    <input type='submit' value='修改'>");
        writer.println("                </div>");
        writer.println("            </form>");
        writer.println("        </div>");
        writer.println("    </div>");
        writer.println("");
        writer.println("</body>");
        writer.println("");
        writer.println("</html>");
    }
}
