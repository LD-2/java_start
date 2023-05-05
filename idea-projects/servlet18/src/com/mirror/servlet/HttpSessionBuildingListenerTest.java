package com.mirror.servlet;

import com.bean.UserA;
import com.bean.UserB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/HttpSessionBuildingListenerTest")
public class HttpSessionBuildingListenerTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        session.setAttribute("userA",new UserA(19,"mirror"));
        session.removeAttribute("userA");


        session.setAttribute("userB",new UserB(19,"ld"));
        session.removeAttribute("userB");
    }
}
