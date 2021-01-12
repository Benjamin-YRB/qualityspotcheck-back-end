package com.focustar.qualityspotcheck.commom.resp;

import java.text.MessageFormat;

/**
 * @Author yangxiansheng
 * @Since 2021/1/12
 * description: 统一响应对象
 */
public class Response<T> {
    public String code;
    public String msg;
    public T data;

    public Response(IRespCode result,Object... values){
        this.code = result.getCode();
        this.msg = result.getMsg();
        analyze(values);
    }

    public Response(T data,IRespCode result,Object... values){
        this.data = data;
        this.code = result.getCode();
        this.msg = result.getMsg();
        analyze(values);
    }

    public Response(T data ,String code,String msg){
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public void fail(T data , String code , String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public void fail(IRespCode result , Object... values){
        this.code = result.getCode();
        this.msg = result.getMsg();
        this.analyze(values);
    }

    public void fail(T data ,IRespCode result , Object... values){
        this.data = data;
        this.code = result.getCode();
        this.msg = result.getMsg();
        this.analyze(values);
    }

    public void success(T data , IRespCode result){
        this.code = IRespCode.SUCCESS_CODE;
        this.msg = null;
        this.data = data;
    }

    public void success(T data){
        this.data = data;
        this.code = IRespCode.SUCCESS_CODE;
        this.msg = null;
    }

    public void analyze(Object... values){
        if (values != null) {
            this.msg = MessageFormat.format(msg,values);
        }
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
