import com.kuang.config.KuangConfig;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    @Test
    public void Test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(KuangConfig.class);
        User getUser = (User) context.getBean("user");
        System.out.println(getUser.getName());

    }
}
