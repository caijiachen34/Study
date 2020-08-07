package com.kuang.service;

import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByName(String userName) {
        return userMapper.selectUserByName(userName);
    }

    @Override
    public int updateUserByName(String userName, String password) {
        return userMapper.updateUserByName(userName,password);
    }
}
