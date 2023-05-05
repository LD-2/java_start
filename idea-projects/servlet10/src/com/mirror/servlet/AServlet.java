package com.mirror.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        req.setAttribute("name","mirror");
        Object name = req.getAttribute("name");
        writer.print(name+"<br>");
        //互相调用会死循环 报服务器中程序错误  500错误
//        req.getRequestDispatcher("/ldMirror/BServlet").forward(req,resp);
    }
}
