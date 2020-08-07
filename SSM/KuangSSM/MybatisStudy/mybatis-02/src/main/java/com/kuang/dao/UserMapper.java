package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectUser();

    User selectUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);





}
