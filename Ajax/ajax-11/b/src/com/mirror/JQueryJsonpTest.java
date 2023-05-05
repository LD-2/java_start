package com.mirror;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/jQueryjsonptest")
public class JQueryJsonpTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(req.getParameter("fun_name")+"({\"name\":\"mirror\"})");
//        resp.getWriter().write(req.getParameter("callback")+"({\"name\":\"mirror\"})");
    }
}
