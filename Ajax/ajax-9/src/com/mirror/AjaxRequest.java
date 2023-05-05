package com.mirror;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AjaxRequest")
public class AjaxRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if(req.getParameter("name").equals("mirror")){
//            out.write("{name:'ld'}");
            out.write("{\"name\":\"ld\"}");
        }else if(req.getParameter("name").equals("ld")){
//            out.write("{name:'mirror'}");
            out.write("{\"name\":\"mirror\"}");
        }else{
//            out.write("{name:'ldMirror'}");
//            out.write("{'name':'ldMirror'}");
//            out.write("{name:\"ldMirror\"}");
            out.write("{\"name\":\"ldMirror\"}");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        System.out.println(req.getParameter("name"));
        if(req.getParameter("name").equals("mirror")){
            out.write("{\"name\":\"ld\"}");
        }else if(req.getParameter("name").equals("ld")){
            out.write("{\"name\":\"mirror\"}");
        }else{
            out.write("{\"name\":\"ldMirror\"}");
        }
    }
}