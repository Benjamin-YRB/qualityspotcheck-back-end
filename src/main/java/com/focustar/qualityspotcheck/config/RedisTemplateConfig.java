package com.focustar.qualityspotcheck.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.Charset;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/15
 * description:
 */
@Configuration
public class RedisTemplateConfig {

    public static final Logger logger = LoggerFactory.getLogger(RedisTemplateConfig.class);


    @Bean
    public RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory){
        FastJson2JsonRedisSerializer<Object> fastJson2JsonSerializer = new FastJson2JsonRedisSerializer<>(Object.class);
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setValueSerializer(fastJson2JsonSerializer);
        template.setHashValueSerializer(fastJson2JsonSerializer);
        template.afterPropertiesSet();
        return template;
    }

    public StringRedisTemplate stringRedisTemplate(LettuceConnectionFactory redisConnectionFactory){
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setValueSerializer(stringRedisSerializer);
        template.setHashValueSerializer(stringRedisSerializer);
        return template;
    }

}

/**
 * 使用FastJson作为redis的序列化器
 * @param <T>
 */
class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T>{
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Class<T> clazz;

    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    public FastJson2JsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        return t == null ? new byte[0] : JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0){
            return null;
        }
        String str = new String(bytes,DEFAULT_CHARSET);

        return JSON.parseObject(str,clazz);
    }
    protected JavaType getJavaType(Class<T> clazz){
        return TypeFactory.defaultInstance().constructType(clazz);
    }
}