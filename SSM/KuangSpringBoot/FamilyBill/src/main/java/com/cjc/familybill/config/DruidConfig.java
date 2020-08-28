package com.cjc.familybill.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控 : web.xml
    // 因为springboot内置了servlet容器，所以没用web,xml,代替方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台有人登录，账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();

        //增加配置,key是固定的
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","admin");

        //允许谁可以访问
        initParameters.put("allow","");

        //禁止谁能访问
        //initParameters.put("kuangshen","192.168.1.111");

        bean.setInitParameters(initParameters );//设置初始化参数
        return bean;
    }

    //filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        //可以过滤那些请求
        Map<String, String> initParameters = new HashMap<>();

        bean.setInitParameters(initParameters);

        //不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        return bean;
    }
}