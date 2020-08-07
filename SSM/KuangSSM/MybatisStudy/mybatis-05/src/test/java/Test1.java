import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test1 {
    @Test
    public void testSelectAll(){
        SqlSession sqlSession= MybatisUtils.getSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession=MybatisUtils.getSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession=MybatisUtils.getSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=new User(5,"hello","111111");
        int i = mapper.addUser(user);
        sqlSession.close();
    }
}
