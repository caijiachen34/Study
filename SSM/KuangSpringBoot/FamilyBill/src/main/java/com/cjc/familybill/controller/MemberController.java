package com.cjc.familybill.controller;

import com.cjc.familybill.service.MemberService;
import com.cjc.familybill.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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


    @ResponseBody
    @PostMapping("/login2")
    public Result login2(String input,String password){
        Result result=memberService.checkLogin2(input, password);
        return result;
    }

    @ResponseBody
    @PostMapping("/check")
    public Result checkIsUsed(String input){
        Result result=memberService.checkIsUsed(input);
        return result;
    }

    @ResponseBody
    @PostMapping("/changepassword2")
    public Result changePasswordByName(String uname,String oldPwd,String newPwd){
        Result result=memberService.updatePwdByName(uname,oldPwd,newPwd);
        return result;
    }


    @ResponseBody
    @RequestMapping("/addImage")
    public Result addImage(@RequestParam("uname") String uname, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        Result result=memberService.addImage(uname,file,request);
        return result;
    }

}
