package com.cjc.contentprovider.dao;

import com.cjc.contentprovider.pojo.User;

import java.util.List;

/**
 * Created by CC
 **/
//数据库接口
public interface IUserDao {
    long addUser(User user);

    int delUserById(int id);

    int updateUser(User user);

    User getUserById(int id);

    List<User> listAllUser();

}
