package com.kuang.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
//这个注解就是说明这个类被spring接管，注册到了容器中
@Component
public class User {
    @Value("cjc")
    private String name;

}
