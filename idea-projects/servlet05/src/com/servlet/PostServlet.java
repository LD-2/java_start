package com.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class PostServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<!DOCTYPE html>");
        writer.print("<html lang=\"en\">");
        writer.print("<head>");
        writer.print("<meta charset=\"UTF-8\">");
        writer.print("<title>Title</title>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print("    <h1>post请求</h1>");
        writer.print("</body>");
        writer.print("</html>");
    }
}
