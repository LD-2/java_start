package com.mirror.controller.pk;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pk")
public class BotInfoController {

    @RequestMapping("/getbotinfo")
    public List<Map<String,String>> getBotInfo(){
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        Map<String,String> bot1 = new HashMap<String,String>();
        bot1.put("name","mirror");
        bot1.put("age","20");
        list.add(bot1);
        Map<String,String> bot2 = new HashMap<String,String>();
        bot2.put("name","ld");
        bot2.put("age","20");
        list.add(bot2);
        return list;
    }
}
