import com.kuang.dao.TeacherMapper;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test1 {
    @Test
    public void selectAllTeacher(){
        SqlSession session= MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.selectAllTeacher();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }

        session.close();
    }

    @Test
    public void selectAllTeacher2(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.selectAllTeacher2(1);
        System.out.println(teacher);
        session.close();


    }

    @Test
    public void selectAllTeacher3(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.selectAllTeacher3(1);
        System.out.println(teacher);
        session.close();


    }



}
