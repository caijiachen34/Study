package com.kuang.pojo;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
//等价于  <bean id="user" class="com.kuang.pojo.User"/>
@Component
@Scope("singleton")
public class User {
      //@Value(""):为字段注入值
      @Value("cjc")
      private String name;
}
