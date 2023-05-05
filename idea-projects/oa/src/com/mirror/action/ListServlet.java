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


public class ListServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req,resp);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String contextPath = req.getContextPath();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("    <meta charset='UTF-8'>");
        writer.println("    <title>list</title>");
        writer.println("    <link rel='stylesheet' href='"+contextPath+"/css/list.css'>");
        writer.println("<script type='text/JavaScript'>");
        writer.println("function del(deptno){");
        writer.println("    if(window.confirm('确认删除')){");
        writer.println("        document.location.href='"+ contextPath +"/ldMirror/DeleteServlet?deptno='+ deptno");
        writer.println("    }else{");
        writer.println("       document.location.href='"+ contextPath +"/ldMirror/ListServlet'");
        writer.println("    }");
        writer.println("}");
        writer.println("</script>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("    <div id='tb'>");
        writer.println("        <table>");
        writer.println("            <caption>部门列表</caption>");
        writer.println("            <thead>");
        writer.println("                <td><button class='add'><a href='"+ contextPath +"/html/add.html'>增添部门</a></button></td>");
        writer.println("                <tr>");
        writer.println("                    <th>序号</th>");
        writer.println("                    <th>部门编号</th>");
        writer.println("                    <th>部门名称</th>");
        writer.println("                    <th>操作</th>");
        writer.println("                </tr>");
        writer.println("            </thead>");
        writer.println("            <tbody>");


        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection=JDBCUtils.getConnection();
            String sql="select deptno,dname from dept";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            int idx=0;
            while (resultSet.next()) {
                int deptno=resultSet.getInt("deptno");
                String dname = resultSet.getString("dname");
                writer.println("                <tr>");
                writer.println("                    <td>"+ ++idx +"</td>");
                writer.println("                    <td>"+ deptno +"</td>");
                writer.println("                    <td>"+ dname +"</td>");
                writer.println("                    <td>");
                writer.println("                        <a href='"+ contextPath +"/ldMirror/UpdateShowServlet?deptno="+ deptno +"' title='update'>修改</a>");
                writer.println("                        <a href='javascript:void(0)' onclick='del("+ deptno +")' title='delete'>删除</a>");
                writer.println("                        <a href='"+ contextPath +"/ldMirror/DetailsServlet?deptno="+ deptno +"' title='details'>部门详情</a>");
                writer.println("                    </td>");
                writer.println("                </tr>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,preparedStatement,resultSet);
        }


        writer.println("            </tbody>");
        writer.println("        </table>");
        writer.println("    </div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
