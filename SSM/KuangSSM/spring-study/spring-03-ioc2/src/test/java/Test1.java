import com.kuang.pojo.User;
import com.kuang.pojo.UserT;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void Test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = (User) context.getBean("alias1");
        UserT userT = (UserT) context.getBean("t3");
        System.out.println(user.toString());
        System.out.println(userT.toString());
    }
}
