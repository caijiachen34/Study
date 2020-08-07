package com.kuang.mapper;


import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    //根据名字查找用户
    User selectUserByName(@Param("userName") String userName);

    int updateUserByName(@Param("userName") String userName,@Param("password") String password);
}
