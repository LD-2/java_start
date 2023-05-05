package com.mirror;

import com.alibaba.fastjson.JSON;
import com.pojo.Area;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/request")
public class ShowArea extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pcode = req.getParameter("code");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Area> list=new ArrayList<Area>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/username","root","123456");
            if(pcode==null) {
                String sql = "select `code`,`name` from `t_area` where `pcode` is null";
                preparedStatement = connection.prepareStatement(sql);
            }else {
                String sql = "select `code`,`name` from `t_area` where `pcode` = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,pcode);
            }
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                list.add(new Area(code,name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String returnJsonObj = JSON.toJSONString(list);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(returnJsonObj);
    }
}
