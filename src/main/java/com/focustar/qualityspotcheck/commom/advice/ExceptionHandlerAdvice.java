package com.focustar.qualityspotcheck.commom.advice;

import com.focustar.qualityspotcheck.commom.enums.RespCode;
import com.focustar.qualityspotcheck.commom.exception.TokenException;
import com.focustar.qualityspotcheck.commom.resp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/15
 * description: 统一异常处理类
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {
    public static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<List<FieldFail>> methodArgumentNotValidException(MethodArgumentNotValidException e){
        logger.info("参数校验异常"+e.getMessage());

        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        List<FieldFail> res = new ArrayList<>();
        for (int i = 0 ; i < errors.size() ; i++){
            FieldError error = errors.get(i);
            FieldFail ff = new FieldFail();
            ff.setErrorMessage(error.getDefaultMessage());
            ff.setField(error.getField());
            ff.setValue(error.getRejectedValue());
            res.add(ff);
        }
        return new Response<>(res,RespCode.FAIL_CHECK);
    }

    @ExceptionHandler({Exception.class})
    public Response<Object> exceptionHandler(HttpServletRequest request, Exception e){
        logger.info("异常来源URI"+request.getRequestURI());
        logger.info("系统发生异常，异常信息为：",e);

        return e instanceof NoHandlerFoundException ? new Response<>(e.getMessage(), RespCode.ERROR_404) : new Response<>(e.getMessage(),RespCode.ERROR_500);

    }

    @ExceptionHandler(TokenException.class)
    public Response<Object> tokenExceptionHandler(TokenException e){
        logger.info("发生token异常，异常信息为："+e);
        return new Response<>(RespCode.TOKEN_FAIL);
    }

    private static class FieldFail{
        String field;
        Object value;
        String errorMessage;

        @Override
        public String toString() {
            return "FieldFail{" +
                    "field='" + field + '\'' +
                    ", value=" + value +
                    ", errorMessage='" + errorMessage + '\'' +
                    '}';
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
