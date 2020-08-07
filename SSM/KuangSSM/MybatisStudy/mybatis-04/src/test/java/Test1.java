import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    static Logger logger = Logger.getLogger(Test1.class);

    @Test
    public void selectAll(){
        SqlSession session= MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users=mapper.selectUser();

        for (User user:users){
            System.out.println(user);
        }

        session.close();
    }

    @Test
    public void TestLog4J(){
        logger.info("info:进入了testLog4J");
        logger.debug("debug:进入了testLog4J");
        logger.error("error:进入了testLog4J");
    }


    @Test
    public void selectLimit(){
        SqlSession session= MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("startIndex",0);
        map.put("pageSize",3);
        List<User> users=mapper.selectLimit(map);

        for (User user:users){
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession session= MybatisUtils.getSession();

        //RowBounds实现
        RowBounds rowBounds = new RowBounds(0, 4);

        List<User> userList = session.selectList("com.kuang.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }


}
