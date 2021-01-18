package com.focustar.qualityspotcheck.commom.advice;

import com.focustar.qualityspotcheck.commom.enums.RespCode;
import com.focustar.qualityspotcheck.commom.resp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/18
 * description:
 */
@RestControllerAdvice
public class ResponseWrapAdvice implements ResponseBodyAdvice<Object> {
    public static final Logger logger = LoggerFactory.getLogger(ResponseWrapAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !(methodParameter.getParameterType().equals(Response.class));
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {
        return new Response<>(o, RespCode.SUCCESS);
    }
}
