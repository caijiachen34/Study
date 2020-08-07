package com.cjc.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjc.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){
        //查询name，邮箱不为空的年龄大于等于12岁的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age",12);
        userMapper.selectList(wrapper).forEach(System.out::println);

    }

    @Test
    public void test2(){
        //关键词查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","hhh");
        System.out.println(userMapper.selectOne(wrapper));
    }

    @Test
    public void test3(){
        //年龄在20-30之间
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",10,20);

        Integer count = userMapper.selectCount(wrapper);//查询结果数
        System.out.println(count);
    }

    @Test
    public void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //左和右
        wrapper.notLike("name","c")
                .likeRight("email","c");

        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id","SELECT id from `user` where id<3");

        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test6(){
        //通过id进行排序
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");

        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }



}
