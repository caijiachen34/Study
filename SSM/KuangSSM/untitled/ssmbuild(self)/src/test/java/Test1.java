import com.cjc.pojo.Books;
import com.cjc.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test1 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookServiceImpl = (BookServiceImpl) context.getBean("BookServiceImpl");
        List<Books> books = bookServiceImpl.queryAllBook();
        for (Books book : books) {
            System.out.println(book);
        }
    }
}
