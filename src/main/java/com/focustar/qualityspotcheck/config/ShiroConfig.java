package com.focustar.qualityspotcheck.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author yangxiansheng
 * @Since 2021/1/11
 * description:
 */
@Configuration
public class ShiroConfig {
    /**
     * 自定义realm
     * @return
     */
    @Bean
    public UserRealm getUserRealm(){
        return new UserRealm();
    }

    /**
     * 安全管理器
     * @return
     */
    @Bean
    public SecurityManager getSecurityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(getUserRealm());

        return manager;
    }

    /**
     * 过滤规则
     * @return
     */
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdCookieEnabled(true);
        return sessionManager;
    }

    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();


        shiroFilterFactoryBean.setSecurityManager(getSecurityManager());

        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();

        shiroFilterFactoryBean.setLoginUrl("/login");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }



}
