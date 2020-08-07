import com.kuang.service.UserService;
import com.kuang.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void Test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //动态代理代理的是接口！！！
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}
