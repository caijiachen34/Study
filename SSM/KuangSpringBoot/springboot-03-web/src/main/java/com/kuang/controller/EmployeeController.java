package com.kuang.controller;

import com.kuang.dto.EmployeeDTO;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import com.kuang.service.DepartmentService;
import com.kuang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<EmployeeDTO> employees = employeeService.selectAllEmployeeDTO();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){
        //查出所有部门的信息
        Collection<Department> departments = departmentService.selectAllDepartment();
        model.addAttribute("departments",departments);
        return "emp/add";
    }


    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("employee==="+employee);
        employeeService.addEmployee(employee);//保存员工信息
        //添加的操作
        return "redirect:/emps";
    }

    //前往员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeService.selectEmployeeById(id);
        model.addAttribute("emp",employee);
        //查出所有部门的信息
        Collection<Department> departments = departmentService.selectAllDepartment();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id,Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/emps";
    }

}
