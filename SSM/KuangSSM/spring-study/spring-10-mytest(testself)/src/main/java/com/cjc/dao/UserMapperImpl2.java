package com.cjc.dao;

import com.cjc.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{

    public User selectUserById(int id) {
        return getSqlSession().getMapper(UserMapper.class).selectUserById(id);
    }
}
