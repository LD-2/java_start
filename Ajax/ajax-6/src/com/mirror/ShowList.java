package com.mirror;

import com.alibaba.fastjson.JSON;
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


        //注意这里的字符串也要表示出来 要完全json对象格式
        StringBuilder jsonObj=new StringBuilder("[");
//        for (int i = 0; i < list.size(); i++) {
//            Person person = list.get(i);
//            jsonObj.append("{\"id\":"+person.getId()+"," +
//                    "\"name\":\""+person.getName()+"\"," +
//                    "\"age\":"+person.getAge()+"," +
//                    "\"address\":\""+person.getAddress()+"\"},");
//        }

//        String jsonStr = jsonObj.substring(0, jsonObj.length() - 1) + "]";
        String jsonStr= JSON.toJSONString(list);
        out.write(jsonStr);
    }
}
