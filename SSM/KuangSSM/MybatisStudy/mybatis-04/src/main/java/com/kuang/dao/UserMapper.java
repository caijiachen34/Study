package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectUser();

    //分页1
    List<User> selectLimit(Map<String,Object> map);

    //分页2
    List<User> getUserByRowBounds();





}
