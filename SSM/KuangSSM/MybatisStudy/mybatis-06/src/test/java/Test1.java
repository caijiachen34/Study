import com.kuang.dao.StudentMapper;
import com.kuang.dao.TeacherMapper;
import com.kuang.pojo.Student;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test1 {
    @Test
    public void selectAllTeacher(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.selectAllTeacher();
        System.out.println(teacher);
        session.close();
    }

    @Test
    public void selectAllStudent(){
        SqlSession session = MybatisUtils.getSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students=mapper.selectAllStudent();
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();
    }

    @Test
    public void getStudent(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent();
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();
    }

    @Test
    public void getStudent2(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent2();
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();
    }

}
