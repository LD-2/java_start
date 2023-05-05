package com.mirror.controller;

import com.mirror.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ShowData {
//1) HttpServletRequest
//2) HttpServletResponse
//3) HttpSession
//4) Model
//5) Map
//6) ModelMap
    @RequestMapping("/showdata.action")
    public String showData(HttpServletRequest request,
                           HttpServletResponse response,
                           HttpSession httpSession,
                           Model model,
                           Map map,
                           ModelMap modelMap){
        request.setAttribute("requestStu",new Student("mirror",20));
        httpSession.setAttribute("sessionStu",new Student("mirror",20));
        model.addAttribute("modelStu",new Student("mirror",20));
        map.put("mapStu",new Student("mirror",20));
        modelMap.addAttribute("modelMapStu",new Student("mirror",20));
        return "main";
    }
}
