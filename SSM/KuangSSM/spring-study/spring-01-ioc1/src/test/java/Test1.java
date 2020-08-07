import com.kuang.dao.UserDaoImpl;
import com.kuang.dao.UserDaoMysqlImpl;
import com.kuang.service.UserServiceImpl;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void test1(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoImpl());
        userService.getUser();

    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //UserServiceImpl userService=context.getBean("UserServiceImpl");
        //userService.getUser();
    }

}
