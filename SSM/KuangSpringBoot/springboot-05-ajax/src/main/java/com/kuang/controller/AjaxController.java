package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1=="+name);
        if ("admin".equals(name)){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList = new ArrayList<>();

        //添加数据
        userList.add(new User("cjc1",1,"男"));
        userList.add(new User("cjc2",2,"女"));
        userList.add(new User("cjc3",3,"男"));

        return userList;
    }

    @RequestMapping(value = "/a3")
    public String a3(String name,String pwd){
        String msg="";
        if (name!=null){
            if ("admin".equals(name)){
                msg = "success";
            }else {
                msg = "false";
            }
        }
        if (pwd!=null){
            if ("123456".equals(pwd)){
                msg = "success";
            }else {
                msg = "false";
            }
        }
        return msg;
    }

}
