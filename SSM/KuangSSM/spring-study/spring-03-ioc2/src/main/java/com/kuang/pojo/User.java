package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }
}
