package com.cjc.dao;

import com.cjc.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User selectUserById(@Param("id") int id);
}
