package com.mirror.servlet;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;


public class GetAnno {
    public static void main(String[] args) {
        Class<AServlet> clazz = AServlet.class;
        if(clazz.isAnnotationPresent(WebServlet.class)){
            WebServlet annotation = clazz.getAnnotation(WebServlet.class);
            String[] value = annotation.value();
            for (String s : value) {
                System.out.println(s);
            }
            for (String s : annotation.urlPatterns()) {
                System.out.println(s);
            }
            String name = annotation.name();
            System.out.println(name);
            WebInitParam[] webInitParams = annotation.initParams();
            for (WebInitParam webInitParam : webInitParams) {
                System.out.println(webInitParam.name()+"  "+webInitParam.value());
            }
        }else {
            System.out.println("NO!");
        }
    }
}
