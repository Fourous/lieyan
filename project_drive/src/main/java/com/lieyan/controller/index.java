package com.lieyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class index {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
