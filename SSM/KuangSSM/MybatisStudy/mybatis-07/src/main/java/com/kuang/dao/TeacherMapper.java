package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> selectAllTeacher();

    //获取指定老师下的所有学生以及老师信息
    Teacher selectAllTeacher2(@Param("tid") int id);

    Teacher selectAllTeacher3(@Param("tid") int id);

}
