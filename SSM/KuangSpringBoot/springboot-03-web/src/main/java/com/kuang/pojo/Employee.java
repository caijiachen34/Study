package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Employee implements Serializable {
    private Integer id;
    private String employeeName;
    private String email;
    private Integer gender; //0:女 1:男
    private int departmentId;
    private Date date;

    public Employee(Integer id, String employeeName, String email, Integer gender, int departmentId) {
        this.id = id;
        this.employeeName = employeeName;
        this.email = email;
        this.gender = gender;
        this.departmentId = departmentId;
        //默认日期
        this.date=new Date();
    }
}
