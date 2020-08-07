package com.kuang.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
@Data
public class EmployeeDTO implements Serializable {
    private int id;
    private String employeeName;
    private String email;
    private int gender;
    private String departmentName;
    private Date date;
}
