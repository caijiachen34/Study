import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test1 {
    @Test
    public void queryUserById(){
        SqlSession session= MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

        //mapper.updateUser(new User(2,"222","222"));

        //User user3 = mapper.queryUserById(2);

        session.clearCache();//手动清除一级缓存

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);
        session.close();
    }

    @Test
    public void queryUserById2(){
        SqlSession session= MybatisUtils.getSession();
        SqlSession session2= MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);
        session.close();
        session2.close();
    }
}
