package com.focustar.qualityspotcheck.commom.util;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/15
 * description:
 */
public class RedisUtil {
    /**
     * 登陆token7天过期
     */
    public static final int LOGIN_TOKEN_ALIVE_TIME = 7;

    /**
     * 登陆token前缀
     */
    public static final String LOGIN_TOKEN_KEY = "login_token_";


    public static void setRedis(RedisTemplate redisTemplate, String key, Object value, long time, TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key,value,time,timeUnit);
    }

    public static Object getRedis(RedisTemplate redisTemplate,String key){
        return redisTemplate.opsForValue().get(key);
    }
}
