import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDUtils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Test1 {

    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreate_time(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }

    @Test
    public void selectBlogIF(){
        SqlSession session= MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","Mybatis如此简单");
        map.put("author","狂神说");
        List<Blog> blogs = mapper.selectBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }

    @Test
    public void queryBlogWhere(){
        SqlSession session= MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("author","狂神说");
        List<Blog> blogs = mapper.queryBlogWhere(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }


    @Test
    public void queryBlogChoose(){
        SqlSession session= MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","Java如此简单");
        map.put("author","狂神说");
        map.put("views","9999");
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }

    @Test
    public void updateBlog(){
        SqlSession session= MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("id","111");
        map.put("title","11");
        map.put("author","11");
        map.put("views","11");
        int i = mapper.updateBlog(map);
        System.out.println(i);
        session.close();
    }

    @Test
    public void selectBlogForeach(){
        SqlSession session= MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);
        List<Blog> blogs = mapper.selectBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }
}
