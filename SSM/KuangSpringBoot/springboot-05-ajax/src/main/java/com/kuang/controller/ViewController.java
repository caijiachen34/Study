package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/views")
public class ViewController {
    @RequestMapping(value = "hello")
    public String hello(){
        return "index";  //与.jsp 文件对应
    }

}

