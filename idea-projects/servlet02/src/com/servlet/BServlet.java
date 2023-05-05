package com.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet implements Servlet {

    public BServlet(){
        System.out.println("BServlet的构造函数...");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("BServlet的init()函数...");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        out.print("<a href=\"/mirror/ldMirror/BServlet\">刷新</a>");
        out.print("<br/>");
        out.print("<a href=\"/mirror/index.html\">index</a>");
        System.out.println("BServlet的service函数");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("BServlet的destroy函数");
    }
}
