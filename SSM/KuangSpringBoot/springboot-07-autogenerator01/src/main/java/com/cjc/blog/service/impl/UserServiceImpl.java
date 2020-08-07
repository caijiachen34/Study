package com.cjc.blog.service.impl;

import com.cjc.blog.pojo.User;
import com.cjc.blog.mapper.UserMapper;
import com.cjc.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjc
 * @since 2020-07-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
