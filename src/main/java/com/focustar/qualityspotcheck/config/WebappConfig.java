package com.focustar.qualityspotcheck.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.focustar.qualityspotcheck.commom.intercepter.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/16
 * description:
 */
@Configuration
public class WebappConfig extends WebMvcConfigurationSupport {

    @Autowired
    LoginInterceptor loginInterceptor;

    /**
     * 配置登陆拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login");

        super.addInterceptors(registry);
    }

    /**
     * 定义消息转化器
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        /*
        1、首先定义一个 convert转换对象
        2、添加fastjson的配置信息
        3、在Convert中添加配置信息
        4、将convert添加到converts中
         */

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.BrowserSecure, SerializerFeature.SkipTransientField);
        config.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.DisableCircularReferenceDetect);
//        		SerializerFeature.WriteNullBooleanAsFalse  //Boolean字段如果为null,输出为false,而非null
//              SerializerFeature.WriteNullStringAsEmpty  //字符类型字段如果为null,输出为”“,而非null
//              SerializerFeature.WriteNullNumberAsZero  //数值字段如果为null,输出为0,而非null
//              SerializerFeature.WriteNullListAsEmpty  //List字段如果为null,输出为[],而非null
//              SerializerFeature.WriteMapNullValue  //是否输出值为null的字段,默认为false
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");

        converter.setFastJsonConfig(config);

        //处理中文乱码
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON);

        //添加convert
        converters.add(converter);

    }
}
