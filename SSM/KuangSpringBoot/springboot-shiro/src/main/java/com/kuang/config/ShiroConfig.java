package com.kuang.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getshiroFilterFactoryBean(@Qualifier("getdefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro内置过滤器
        /*
        anon:无需认证就可访问
        authc:必须认证了才能访问
        usr必须拥有记住我才能用
        perms：拥有对某个资源的权限才能访问
        role：拥有某个角色权限才能访问
        */

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/*","authc");
//        filterMap.put("/user/add","authc");
//        filterMap.put("/user/update","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录请求
        bean.setLoginUrl("/toLogin");
        return bean;
    }

    //DefaultWebSecurityManager
    @Bean("getdefaultWebSecurityManager")
    public DefaultWebSecurityManager getdefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);

        return securityManager;
    }

    //创建Realm对象
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
