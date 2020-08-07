package com.cjc.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjc.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    void contextLoads(){
        //参数是wrapper
        List<User> users = mapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    //测试插入
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("cjc3");
        user.setAge(2);
        user.setEmail("cjc3@qq.com");
        int insert = mapper.insert(user); //自动生成id，默认值为全局唯一id
        System.out.println(insert); //受影响的行数
        System.out.println(user);
    }

    //测试更新
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1288642466131480580L);
        user.setName("cc31");
        System.out.println(mapper.updateById(user));
    }

    //测试乐观锁(单线程：成功)
    @Test
    public void testLockerSuccess(){
        //查询用户信息
        User user = mapper.selectById(1L);
        //修改用户信息
        user.setName("caijiachen");
        user.setAge(12);
        //执行更新操作
        mapper.updateById(user);
    }

    //测试乐观锁(多线程：失败)
    @Test
    public void testLockerFail(){
        //线程1
        User user = mapper.selectById(1L);
        user.setName("caijiachen111");
        user.setAge(12);
        //线程2
        User user2 = mapper.selectById(1L);
        user.setName("caijiachen222");
        user.setAge(12);
        //执行更新操作
        mapper.updateById(user);
    }

    @Test
    public void testSelectById(){
        //测试id查询
        User user = mapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testSelectByBatchIds(){
        //测试批量id查询
        List<User> users = mapper.selectBatchIds(Arrays.asList(1,2,3));
        System.out.println(users);
    }

    @Test
    public void testSelectByMap(){
        //测试条件查询Map
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","caijiachen222");
        map.put("age",12);
        List<User> users = mapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testPage(){
        //测试分页查询
        //参数一：当前页
        //参数二：页面大小
        Page<User> page = new Page<>(1,5);
        mapper.selectPage(page,null);
        //打印总页数
        System.out.println(page.getTotal());

        for (User record : page.getRecords()) {
            System.out.println(record);
        }
    }

    @Test
    public void testDelete(){
        //通过id删除
        mapper.deleteById(2L);
    }

    @Test
    public void testDeleteByBatchIds(){
        //批量删除
        mapper.deleteBatchIds(Arrays.asList(1288642466131480579l,11));
    }

    @Test
    public void testDeleteByMap(){
        //Map删除
        HashMap<String, Object> map = new HashMap<>();
        map.put("age","24");
        System.out.println(mapper.deleteByMap(map));
    }

    /*
    * 物理删除：数据库中删除
    * 逻辑删除：未被移除，通过变量使之失效 deleted=0 => deleted=1
    * */
    @Test
    public void testDeletedId(){
        //Map删除
        HashMap<String, Object> map = new HashMap<>();
        map.put("age","24");
        System.out.println(mapper.deleteByMap(map));
    }

}