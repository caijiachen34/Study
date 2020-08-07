package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectUser();

    User selectUserById(int id);

    User selectUserByNP(@Param("name") String name, @Param("pwd") String pwd);

    User selectUserByNP2(Map<String ,Object> map);

    User selectByName(String name);

    int addUser(User user);

    int updateUser(User user);

    int updateUser2(Map<String,Object> map);

    int deleteUser(int id);

    List<User> getUserLike(String value);



}
