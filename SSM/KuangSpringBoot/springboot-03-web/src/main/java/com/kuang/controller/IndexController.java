package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping("/user/login")
    //@RequestParam获取前端参数
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){

        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            //登录成功后就生成loginUser
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","用户名或密码错误！！！");
            return "index";
        }

    }


    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
