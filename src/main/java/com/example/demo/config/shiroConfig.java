package com.example.demo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author
 * @date 2020/10/10
 **/
@Configuration
public class shiroConfig {


    //ShiroFilterFactoryBean
    //DefaultWebSecurityManager
    //UserRealm

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        factoryBean.setSecurityManager(securityManager);
        //添加shiro的内置过滤器
        /*
            anon: 无需认证就可访问
            authc：必须认证才能访问
            user：必须拥有记住我功能才能访问
            perms: 拥有对某个资源的权限才能访问
            roles:拥有某个角色权限才能访问 roles[admin] roles[staff]
       */
        Map<String, String> filterMap = new LinkedHashMap<>();
        // 静态资源放行
       /* filterMap.put("/static/**", "anon");
        filterMap.put("/user/login", "anon");*/
        /*页面*/
        filterMap.put("/about", "authc");//认证过滤器
        filterMap.put("/mysalary", "authc");//认证过滤器
        filterMap.put("/deptlist", "authc");//认证过滤器
        filterMap.put("/stafflist", "authc");//认证过滤器
        filterMap.put("/leave", "authc");//认证过滤器
        filterMap.put("/salarylist", "roles[admin]");//认证过滤器
        filterMap.put("/operationleave", "roles[admin]");//认证过滤器
        filterMap.put("/roleapproval", "roles[admin]");//认证过滤器
        /*接口*/
        filterMap.put("/user/login", "anon");
        filterMap.put("/*/addstaff", "roles[admin]");//认证过滤器
        filterMap.put("/*/deletestaff", "roles[admin]");//认证过滤器
        filterMap.put("/*/activite", "roles[admin]");//认证过滤器
        filterMap.put("/*/adddu", "roles[admin]");//认证过滤器
        filterMap.put("/*/addddept", "roles[admin]");//认证过滤器
        filterMap.put("/*/delete", "roles[admin]");//认证过滤器
        filterMap.put("/*/activite", "roles[admin]");//认证过滤器
        filterMap.put("/*/setsalary", "roles[admin]");//认证过滤器
        filterMap.put("/*/salarylist", "roles[admin]");//认证过滤器
        filterMap.put("/*/disagree", "roles[admin]");//认证过滤器
        filterMap.put("/*/agree", "roles[admin]");//认证过滤器
        filterMap.put("/*/updaterole", "roles[admin]");//认证过滤器
        filterMap.put("/*/disagreeupdaterole", "roles[admin]");//认证过滤器
        //退出路径
        filterMap.put("/logout", "logout");

        factoryBean.setFilterChainDefinitionMap(filterMap);
        //设置登录url
        factoryBean.setLoginUrl("/login");
        //没有权限跳转
        factoryBean.setUnauthorizedUrl("/noauth");
        return factoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联userRelam
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }


    //整合thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
