package com.cjc.familybill.controller;

import com.cjc.familybill.service.MemberService;
import com.cjc.familybill.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    //注册
    @ResponseBody
    @PostMapping
    public Result register(String uname,String password,String email,String mobile){
        System.out.println("uname:"+uname);
        System.out.println("password:"+password);
        System.out.println("email:"+email);
        Result result = memberService.registMember(uname, password, email, mobile);
        return result;
    }

    @ResponseBody
    @PostMapping("/login")
    public Result login(String uname,String password){
        Result result = memberService.checkLogin(uname,password);
        return result;
    }


}
