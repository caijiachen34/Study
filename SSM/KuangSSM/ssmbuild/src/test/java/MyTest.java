import com.kuang.pojo.Books;
import com.kuang.service.BooksService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksService bookServiceImpl = (BooksService) context.getBean("BookServiceImpl");
        for (Books books : bookServiceImpl.queryAllBook()) {
            System.out.println(books);
        }


    }
}
