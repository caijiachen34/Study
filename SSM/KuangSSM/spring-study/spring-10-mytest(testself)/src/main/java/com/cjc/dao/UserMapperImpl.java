package com.cjc.dao;

import com.cjc.pojo.User;
import org.apache.ibatis.session.SqlSession;

public class UserMapperImpl implements UserMapper{

    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User selectUserById(int id) {
        return sqlSession.getMapper(UserMapper.class).selectUserById(id);
    }
}
