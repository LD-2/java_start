package com.mirror.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

public class ARequest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        
        writer.println("request.getParameterMap(): <br>");
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            writer.print(entry.getKey()+" : ");
            for (String name : entry.getValue()) {
                writer.print(name+" ");
            }
            writer.print("<br>");
        }
        writer.print("<br>");


        writer.println("request.getParameterNames(): <br>");
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            writer.println(parameterNames.nextElement()+" ");
        }
        writer.println("<br>");

        writer.println("request.getParameterValues(): <br>");
        String[] interests = request.getParameterValues("interest");
        for (String interest : interests) {
            writer.println(interest+" ");
        }
        writer.println("<br>");

        writer.println("request.getParameter(): <br>");
        writer.println(request.getParameter("qq"));
        writer.println("<br>");
    }
}
