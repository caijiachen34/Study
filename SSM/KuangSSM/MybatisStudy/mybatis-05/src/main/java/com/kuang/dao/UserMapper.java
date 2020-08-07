package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from user")
    public List<User> selectAll();

    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);




}
