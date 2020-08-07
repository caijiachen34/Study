package com.cjc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjc.pojo.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository //代表持久层
public interface UserMapper extends BaseMapper<User> {


}
