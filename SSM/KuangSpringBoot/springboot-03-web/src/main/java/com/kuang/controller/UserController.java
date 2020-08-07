package com.kuang.controller;

import com.kuang.pojo.User;
import com.kuang.service.UserService;
import com.kuang.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/selectPasswordByName/{userName}")
    public User selectUserByName(@PathVariable("userName") String userName){
        User user = userService.selectUserByName(userName);
        return user;
    }

    @GetMapping("/updateUserByName/{userName}/{password}")
    public String updateUserByName(@PathVariable("userName") String userName,@PathVariable("password") String password){
        userService.updateUserByName(userName,password);
        return "updateUserByName OK!";
    }
}
