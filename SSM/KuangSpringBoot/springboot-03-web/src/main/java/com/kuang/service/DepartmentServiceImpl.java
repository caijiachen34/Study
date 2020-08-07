package com.kuang.service;

import com.kuang.mapper.DepartmentMapper;
import com.kuang.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }
}
