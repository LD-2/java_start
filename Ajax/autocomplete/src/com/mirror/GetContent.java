package com.mirror;

import com.alibaba.fastjson.JSON;
import com.pojo.Content;
import com.utils.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getContent")
public class GetContent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Content> list=new ArrayList<Content>();
        try {
            connection= JDBCUtil.getConnection();
            String sql="select `content` from t_ajax where `content` like ?";
            preparedStatement=connection.prepareStatement(sql);
            //模糊查询的时候，条件不建议使用%开始，因为会让字段上的索引失效，查询效率降低.
            preparedStatement.setString(1,req.getParameter("content")+"%");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String content = resultSet.getString("content");
                list.add(new Content(content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection,preparedStatement,resultSet);
        }
        String returnJsonObj = JSON.toJSONString(list);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(returnJsonObj);
    }
}
