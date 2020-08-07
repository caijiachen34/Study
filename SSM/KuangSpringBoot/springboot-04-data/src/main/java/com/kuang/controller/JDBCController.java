package com.kuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库所有信息
    //没用实体类，数据库内容如何获取：map
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into mybatis.user(id,name,pwd) values (6,'嘿嘿','123456')";
        jdbcTemplate.update(sql);
        return "add ok";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update mybatis.user set name=?,pwd=? where id ="+id;
        Object[] objects = new Object[2];
        objects[0] = "test";
        objects[1] = "test";
        jdbcTemplate.update(sql,objects);
        return "update ok";
    }

    @GetMapping("/delUser/{id}")
    public String delUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id=" + id;
        jdbcTemplate.update(sql);
        return "delete ok";
    }



}
