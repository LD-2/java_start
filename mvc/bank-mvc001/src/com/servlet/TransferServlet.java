package com.servlet;

import com.exception.AccountNotEnoughException;
import com.exception.AppException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;


/*
*
* 横向看叫做MVC  纵向看叫三层架构
* 在不使用MVC架构模式的前提下
* 分析这个程序存在的问题
* 缺点一: 代码的复用性太差
*   导致缺点一的原因: 没有进行"职能分工"，没有独立组件的概念 所以代码的复用性差 代码和代码之间的耦合度太高 扩展力太差
* 缺点二: 耦合度高，导致了代码很难扩展
* 缺点三: 操作数据库的代码和业务逻辑混合在一起 很容易出错 编写代码容易出错
* 分析此Servlet都负责了什么
*   1、负责了数据的接收
*   2、负责了代码逻辑的编写   （负责了核心的业务逻辑）
*   3、负责了前端页面的展示   （负责了页面的数据展示）
*   4、负责了数据库中的CRUD操作 Create[增] Retrieve[查] Update[改] Delete[删]
*   .....
*
*/
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        //接收前端传来的数据
        String fromact = req.getParameter("fromact");
        String toact = req.getParameter("toact");
        Double account = Double.parseDouble(req.getParameter("account"));

        //逻辑为 连接后端 先从后端查询转账人的转账信息 如果金额过少 就不执行转账操作
        //然后再执行数据更新操作 注意事务问题

        Connection connection= null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        PreparedStatement ps2=null;
        PreparedStatement ps3=null;
        InputStream resourceAsStream = TransferServlet.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        properties.load(resourceAsStream);
        String driverClass = properties.getProperty("driverClass");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);


            String sql="select balance from `t_act` where actno=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,fromact);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                double balance = resultSet.getDouble("balance");
                if(balance<account){
                    //银行钱不够了 就不转账操作了
                    //抛出余额不足异常
                    throw new AccountNotEnoughException("对不起, 余额不足..");
                }else{
                    //执行转账操作  对表内数据改动
                    String sql2="update `t_act` set balance=balance-? where actno=?";
                    ps2=connection.prepareStatement(sql2);
                    ps2.setDouble(1,account);
                    ps2.setString(2,fromact);
                    int count = ps2.executeUpdate();

                    //模拟网络异常 回滚数据
                    System.out.println(10/0);

                    String sql3="update `t_act` set balance=balance+? where actno=?";
                    ps3=connection.prepareStatement(sql3);
                    ps3.setDouble(1,account);
                    ps3.setString(2,toact);
                    count += ps3.executeUpdate();
                    if(count!=2){
                        throw new AppException("App出现异常, 请联系管理员..");
                    }
                }
            }
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            String message = e.getMessage();
            out.write(message);
        } finally {
            try {
                if(resultSet!=null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(ps2!=null){
                    ps2.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(ps3!=null){
                    ps3.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
