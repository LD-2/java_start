package com.mirror.action;

import com.mirror.bean.Dept;
import com.mirror.utils.JDBCUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/dept/list","/dept/show","/dept/update","/dept/delete","/dept/add"})
public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession(false);
//        if(session!=null&&session.getAttribute("username")!=null) {
//            String servletPath = req.getServletPath();
//            if ("/dept/list".equals(servletPath)) {
//                this.doList(req, resp);
//            } else if ("/dept/show".equals(servletPath)) {
//                this.doShow(req, resp);
//            } else if ("/dept/update".equals(servletPath)) {
//                this.doUpdate(req, resp);
//            } else if ("/dept/delete".equals(servletPath)) {
//                this.Delete(req, resp);
//            } else if ("/dept/add".equals(servletPath)) {
//                this.doAdd(req, resp);
//            }
//        }else{
//            resp.sendRedirect(req.getContextPath());
//        }

        String servletPath = req.getServletPath();
        if ("/dept/list".equals(servletPath)) {
            this.doList(req, resp);
        } else if ("/dept/show".equals(servletPath)) {
            this.doShow(req, resp);
        } else if ("/dept/update".equals(servletPath)) {
            this.doUpdate(req, resp);
        } else if ("/dept/delete".equals(servletPath)) {
            this.Delete(req, resp);
        } else if ("/dept/add".equals(servletPath)) {
            this.doAdd(req, resp);
        }
    }


    private void doAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String contextPath = req.getContextPath();
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
        if(count!=0){
            resp.sendRedirect(contextPath+"/dept/list");
        }
    }

    private void Delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno = req.getParameter("deptno");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String contextPath = req.getContextPath();
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
        if(count!=0){
            resp.sendRedirect(contextPath+"/dept/list");
        }
    }

    private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String contextPath = req.getContextPath();
        int count=0;
        try {
            connection=JDBCUtils.getConnection2();
            String dname = req.getParameter("dname");
            String loc = req.getParameter("loc");
            String sql="update dept set dname=?,loc=? where deptno=?";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,dname);
            preparedStatement.setString(2,loc);
            String deptno = req.getParameter("deptno");
            preparedStatement.setString(3,deptno);
            count = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,preparedStatement,null);
        }
        if(count!=0){
            resp.sendRedirect(contextPath+"/dept/list");
        }
    }

    private void doShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection=JDBCUtils.getConnection2();
            String sql="select deptno,dname,loc from dept where deptno=?";
            String deptno = req.getParameter("deptno");
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,deptno);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int dno = resultSet.getInt("deptno");
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");
                Dept dept=new Dept(dno,dname,loc);
                req.setAttribute("dept",dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,preparedStatement,resultSet);
        }
        String flag = req.getParameter("flag");
        if("details".equals(flag)){
            req.getRequestDispatcher("/details.jsp").forward(req,resp);
        }else if("update".equals(flag)){
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        }
    }

    private void doList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection= JDBCUtils.getConnection2();
            String sql="select deptno,dname,loc from dept";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            List<Dept> list=new ArrayList<Dept>();
            while (resultSet.next()) {
                int deptno = resultSet.getInt(1);
                String dname = resultSet.getString(2);
                String loc = resultSet.getString(3);
                list.add(new Dept(deptno,dname,loc));
            }
            req.setAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,preparedStatement,resultSet);
        }
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
}
