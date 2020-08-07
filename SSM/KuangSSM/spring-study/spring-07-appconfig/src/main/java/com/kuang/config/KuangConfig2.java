package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  /*这个也会被spirng托管，注册到容器中，因为他本来就是一个@Component，
@Configuration代表这是一个配置类，就和我们的bean.xml一样*/
@ComponentScan("com.kuang.pojo")
public class KuangConfig2 {



}
