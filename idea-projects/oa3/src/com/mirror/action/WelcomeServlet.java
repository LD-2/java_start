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
import java.sql.SQLException;
import java.util.Enumeration;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String username=null;
        String password=null;
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if("username".equals(cookie.getName())){
                    username=cookie.getValue();
                }else if("password".equals(cookie.getName())){
                    password=cookie.getValue();
                }
            }
        }
        if(username!=null&&password!=null){
            Connection connection=null;
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            boolean flag=false;
            try {
                connection= JDBCUtils.getConnection2();
                String sql="select * from t_user where username=?and password=?";
                preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    String username1 = resultSet.getString("username");
                    String password1 = resultSet.getString("password");
                    if(username.equals(username1)&&password.equals(password1)){
                        flag=true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.closeResources(connection,preparedStatement,resultSet);
            }
            if(flag){
                HttpSession session = req.getSession();
                session.setAttribute("username",username);
                //过滤器人数+1
                session.setAttribute("user",new User(username,password));

                //这里的session没设置cookie age按理来说 存在内存中 每次打开浏览器 新建一个会话  测试一下
                Enumeration<String> attributeNames = session.getAttributeNames();
                int idx=0;
                if(attributeNames.hasMoreElements()){
                    idx++;
                }
                System.out.println(idx);


                resp.sendRedirect(req.getContextPath()+"/dept/list");
            }else{
                resp.sendRedirect(req.getContextPath()+"index.jsp");
            }
        }else{
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }
    }
}
