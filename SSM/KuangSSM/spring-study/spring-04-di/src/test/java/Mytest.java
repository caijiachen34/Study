import com.kuang.pojo.Student;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    @Test
    public void Test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());

    }


    @Test
    public void Test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbean.xml");
        User user = (User) context.getBean("user2");
        User user2 = (User) context.getBean("user2");
        System.out.println(user==user2);
        System.out.println(user.toString());

    }
}
