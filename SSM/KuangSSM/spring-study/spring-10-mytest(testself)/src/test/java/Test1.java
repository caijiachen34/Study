import com.cjc.dao.UserMapper;
import com.cjc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class Test1 {
    @Test
    public void selectUserById() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void selectUserById2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper mapper = (UserMapper) context.getBean("userDao");
        User user = mapper.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void selectUserById3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper mapper = (UserMapper) context.getBean("userDao2");
        User user = mapper.selectUserById(1);
        System.out.println(user);
    }
}
