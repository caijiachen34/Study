package com.kuang.service;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    User selectUserByName(String userName);

    int updateUserByName(String userName,String password);

}
