package com.cjc.familybill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.cjc.dao")
@SpringBootApplication
public class FamilybillApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilybillApplication.class, args);
    }

}
