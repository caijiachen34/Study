import com.kuang.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Test1 {

    @Test
    public void selectAll(){
        SqlSession session= MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users=mapper.selectUser();

        for (User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void selectUserById(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }

    @Test
    public void selectUserByNP(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user = mapper.selectUserByNP("狂神", "123456");
        System.out.println(user);
        session.close();
    }

    @Test
    public void selectUserByNP2(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","张三");
        map.put("pwd","abcdef");
        User user = mapper.selectUserByNP2(map);
        System.out.println(user);
        session.close();
    }

    @Test
    public void selectUserByName(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user = mapper.selectByName("111");
        System.out.println(user);
        session.close();
    }
    @Test
    public void testAddUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(5,"王五","zxcvbn");
        int i = mapper.addUser(user);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(4);
        user.setPwd("12345");
        user.setName("蔡嘉辰");
        int i = mapper.updateUser(user);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testUpdateUser2() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String , Object> map = new HashMap<String, Object>();
        map.put("id","4");
        map.put("name","cjc");
        map.put("pwd","cjc");
        int i = mapper.updateUser2(map);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.deleteUser(5);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void getUserLike() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("%李%");
        for (User user:userList){
            System.out.println(user);
        }

        session.close();
    }
}
