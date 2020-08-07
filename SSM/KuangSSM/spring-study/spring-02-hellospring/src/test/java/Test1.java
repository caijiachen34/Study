import com.kuang.pojo.Hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void Test1(){
        //获取spring上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //取出对象Hello
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());


    }
}
