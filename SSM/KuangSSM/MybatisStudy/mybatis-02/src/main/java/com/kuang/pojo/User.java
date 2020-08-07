package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("user")
public class User {
    private int id;  //id
    private String name;   //姓名
    private String pwd;   //密码

}
