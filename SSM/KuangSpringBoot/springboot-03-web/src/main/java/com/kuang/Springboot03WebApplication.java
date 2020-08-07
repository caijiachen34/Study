package com.kuang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.kuang.mapper")
public class Springboot03WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03WebApplication.class, args);
    }

}
