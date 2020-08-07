import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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
}
