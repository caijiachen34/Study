package com.kuang.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

@Data
public class People {
    private String name;

    //@Resource可以自动根据类型和名字进行注入，默认按照名称注入
    @Resource(name = "cat11")
    @Autowired(required = false)
    private Cat cat;

    // @Autowired默认按类型注入
    //required=false ：该字段可以为空
    @Autowired(required = false)
    //@Qualifier指定装配的id值
    @Qualifier("dog11")
    private Dog dog;
}
