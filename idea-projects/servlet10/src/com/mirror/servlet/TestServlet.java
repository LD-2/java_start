package com.mirror.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();


        StringBuffer requestURL = req.getRequestURL();
        String method = req.getMethod();
        writer.print(contextPath);
        writer.print("<br/>");
        writer.print(servletPath);
        writer.print("<br/>");
        writer.print(requestURL);
        writer.print("<br/>");
        writer.print(method);

        writer.print("<br/>");
        writer.print("<br/>");
        writer.print(this.getServletContext().getContextPath());
        writer.print("<br/>");
        writer.print(this.getServletContext().getRealPath("web.xml"));
        writer.print("<br/>");
    }
}
