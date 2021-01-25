package com.focustar.qualityspotcheck.commom.intercepter;

import com.focustar.qualityspotcheck.commom.exception.TokenException;
import com.focustar.qualityspotcheck.commom.util.RedisUtil;
import com.focustar.qualityspotcheck.pojo.vo.LoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/16
 * description: 登录token拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 执行请求前处理
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        logger.info("开始校验token："+token+",请求路径为"+request.getRequestURI());
        if (token == null){
            throw new TokenException("token不存在，请先登陆!");
        }

        LoginVO loginVO = (LoginVO) RedisUtil.getRedis(redisTemplate, RedisUtil.LOGIN_TOKEN_KEY+token);

        if (loginVO == null){
            throw new TokenException("token已过期，请重新登陆!");
        }
        logger.info("token校验通过");
        return true;
    }
}
