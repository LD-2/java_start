package com.mirror.action;

import com.mirror.bean.User;
import com.mirror.utils.JDBCUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet({"/user/login","/user/exit"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        if("/user/login".equals(servletPath)){
            doLogin(req,resp);
        }else if("/user/exit".equals(servletPath)){
            doExit(req,resp);
        }
    }

    private void doExit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        //监听器会人数-1
        session.removeAttribute("user");

        //手动销毁session
        session.invalidate();



        //销毁cookie退出系统把所有的cookie销毁
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
//                String name = cookie.getName();
//                if("username".equals(name)||"password".equals(name)){
                //设置cookie有效期为0 表示删除该同名cookie
                cookie.setMaxAge(0);
                //设置cookie路径
                cookie.setPath(req.getContextPath());
                //响应cookie给浏览器会覆盖之前的cookie
                resp.addCookie(cookie);
//                }
            }
        }
        resp.sendRedirect(req.getContextPath());
    }

    private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean flag=false;
        String contextPath = req.getContextPath();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection= JDBCUtils.getConnection2();
            String sql="select * from t_user where username=? and password=?";
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                flag=true;
            }else{
                flag=false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,preparedStatement,resultSet);
        }
        if(flag){

            if("1".equals(req.getParameter("f"))) {
                //如果登入成功且选择了十天内免登录则服务器需要返回浏览器一个cookie对象
                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("password", password);
                cookie1.setMaxAge(60 * 60 * 24 * 10);
                cookie2.setMaxAge(60 * 60 * 24 * 10);
                cookie1.setPath(contextPath);
                cookie2.setPath(contextPath);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            }
            //jsp文件内置九大对象session对象
            HttpSession session = req.getSession();
            session.setAttribute("username",username);

            //监听器会人数+1
            session.setAttribute("user",new User(username,password));


            resp.sendRedirect(contextPath+"/dept/list");
        }else{
            resp.sendRedirect(contextPath+"/error.jsp");
        }
    }
}
