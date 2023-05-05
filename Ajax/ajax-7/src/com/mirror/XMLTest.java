package com.mirror;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request")
public class XMLTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml;charset=utf-8");
        PrintWriter out = resp.getWriter();
        StringBuilder xml=new StringBuilder();
//    out.write("<students>");
//    out.write("<student>");
//    out.write("    <name>mirror</name>");
//    out.write("    <age>12</age>");
//    out.write("</student>");
//    out.write("<student>");
//    out.write("    <name>ld</name>");
//    out.write("    <age>13</age>");
//    out.write("</student>");
//    out.write("</students>");
        xml.append("<students>");
        xml.append("<student>");
        xml.append("<name>mirror</name>");
        xml.append("<age>12</age>");
        xml.append("</student>");
        xml.append("<student>");
        xml.append("<name>ld</name>");
        xml.append("<age>13</age>");
        xml.append("</student>");
        xml.append("</students>");
        out.print(xml);
    }
}
