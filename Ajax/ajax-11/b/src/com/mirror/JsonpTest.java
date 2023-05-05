package com.mirror;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/jsonptest")
public class JsonpTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //响应js代码
        //        resp.getWriter().write("alert('jsonp')");

//        resp.getWriter().write("sayHello()");
        //浏览器内置的alert()  或者 自己定义的sayHello() 都是浏览器调用的 字符串自动转换为了js代码


        //响应js代码 动态函数名  传递前端json格式的数据
        resp.getWriter().write(req.getParameter("fun_name")+"({\"name\":\"mirror\"})");
    }
}
