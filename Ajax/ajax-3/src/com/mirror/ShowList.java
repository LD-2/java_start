package com.mirror;

import com.bean.Person;
import com.utils.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/request")
public class ShowList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Person> list=new ArrayList<Person>();
        try {
            connection= JDBCUtil.getConnection();
            String sql="select `id`,`name`,`age`,`address` from `person`";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                String address = resultSet.getString("address");
                list.add(new Person(id,name,age,address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection,preparedStatement,resultSet);
        }
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            out.write("<tr>");
            out.write("<td>"+person.getId()+"</td>");
            out.write("<td>"+person.getName()+"</td>");
            out.write("<td>"+person.getAge()+"</td>");
            out.write("<td>"+person.getAddress()+"</td>");
            out.write("</tr>");
        }
    }
}
