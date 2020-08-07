package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration  /*这个也会被spirng托管，注册到容器中，因为他本来就是一个@Component，
@Configuration代表这是一个配置类，就和我们的bean.xml一样*/
@ComponentScan("com.kuang.pojo")
@Import(KuangConfig2.class)
public class KuangConfig {

    /*注册一个bean，就相当于之前写的一个bean标签，
    这个方法的名字就相当于bean标签中的id属性，
    这个方法的返回值，就相当于bean标签的class属性
    */
    @Bean
    public User user(){
        return new User();//就是返回要注入到bean的对象
    }

}
