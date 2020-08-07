package com.cjc.controller;

import com.cjc.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @ResponseBody
    @RequestMapping("/json1")
    public String json1() throws JsonProcessingException {
        //ObjectMapper对象映射器，将对象转换为json字符串
        ObjectMapper mapper = new ObjectMapper();
        User user1 = new User("秦疆1号", 3, "男");
        User user2 = new User("秦疆2号", 3, "男");
        User user3 = new User("秦疆3号", 3, "男");
        User user4 = new User("秦疆4号", 3, "男");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        String s = mapper.writeValueAsString(list);
        return s;
    }

    @ResponseBody
    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {
        //ObjectMapper对象映射器，将对象转换为json字符串
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        String s = mapper.writeValueAsString(date);
        return s;
    }


    @ResponseBody
    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {
        //ObjectMapper对象映射器，将对象转换为json字符串
        ObjectMapper mapper = new ObjectMapper();
        //不返回时间戳，就要关闭时间戳功能
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
        //自定义日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(simpleDateFormat);
        Date date = new Date();
        String s = mapper.writeValueAsString(date);
        return s;
    }
}
