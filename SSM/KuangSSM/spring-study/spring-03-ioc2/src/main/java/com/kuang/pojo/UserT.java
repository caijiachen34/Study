package com.kuang.pojo;

import lombok.Data;

@Data
public class UserT {
    private String name;

    public UserT() {
        System.out.println("UserT构造函数");
    }
}
