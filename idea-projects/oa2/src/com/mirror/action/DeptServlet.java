package com.mirror.action;

import com.mirror.utils.JDBCUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@WebServlet({"/ldMirror/ListServlet","/ldMirror/AddServlet","/ldMirror/DeleteServlet","/ldMirror/UpdateServlet","/ldMirror/UpdateShowServlet","/ldMirror/DetailsServlet"})
@WebServlet("/ldMirror/*") //模糊匹配
public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String servletPath = req.getServletPath();
        String servletPath = req.getServletPath()+req.getPathInfo(); //  /ldMirror + /....
        if("/ldMirror/ListServlet".equals(servletPath)){
            this.List(req,resp);
        }else if("/ldMirror/AddServlet".equals(servletPath)) {
            this.Add(req,resp);
        }else if("/ldMirror/DeleteServlet".equals(servletPath)){
            this.Delete(req,resp);
        }else if("/ldMirror/UpdateServlet".equals(servletPath)){
            this.Update(req,resp);
        }else if("/ldMirror/UpdateShowServlet".equals(servletPath)){
            this.UpdateShow(req,resp);
        }else if("/ldMirror/DetailsServlet".equals(servletPath)){
            this.Details(req,resp);
        }

    }

    private void List(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    private void Add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            writer.println("document.location.href='/oa2/ldMirror/ListServlet';");
            writer.println("}");
            writer.println("else");
            writer.println("{");
            writer.println("document.location.href='/oa2/ldMirror/ListServlet';");
            writer.println("}");
//            req.getRequestDispatcher("/ldMirror/ListServlet").forward(req,resp);
            writer.println("</script>");
        }
    }

    private void Delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            resp.sendRedirect("/oa2/html/error.html");
        }else{
//            req.getRequestDispatcher("/ldMirror/ListServlet").forward(req,resp);
            //请求还是一个  因此上面地址栏还是显示deleteServlet的路径资源

            resp.sendRedirect("/oa2/ldMirror/ListServlet");
        }
    }

    private void Update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            resp.sendRedirect("/oa2/html/error.html");
        }else{
//            req.getRequestDispatcher("/ldMirror/ListServlet").forward(req,resp);
            resp.sendRedirect("/oa2/ldMirror/ListServlet");
        }
    }

    private void UpdateShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    private void Details(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
