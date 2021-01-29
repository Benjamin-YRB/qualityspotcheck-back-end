package com.focustar.qualityspotcheck.commom.enums;

import com.focustar.qualityspotcheck.commom.resp.IRespCode;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/15
 * description:
 */
public enum  RespCode implements IRespCode {
    SUCCESS("000000", "成功"),
    FAIL("100000", "失败"),

    DATE_ERROR("100001","开始日期不能晚于结束日期"),

    FAIL_CHECK("100001", "参数校验失败"),
    FAIL_DEAL("100002", "业务处理失败"),
    TOKEN_FAIL("100003", "TOKEN不存在或已过期"),

    ERROR("999999", "异常"),

    ERROR_404("404", "请求的资源不存在"),
    ERROR_403("403", "禁止访问"),
    ERROR_500("500", "系统异常"),

    SYSTEM_ERROR_UNKNOWN("-1", "系统繁忙，请稍后再试...."),

    FAIL_SAVE("200100", "信息保存失败"),
    FAIL_QUERY("200101", "信息查询失败"),
    FAIL_UPDATE("200102", "信息更新失败"),
    FAIL_DELETE("200102", "信息删除失败"),




    FAIL_PARAMETER("200400", "请求参数错误"),
    FAIL_FILE_NONE("200500", "请上传文件"),
    FAIL_FILE_TYPE("200600", "上传的文件类型错误：请上传{0}文件"),
    FAIL_FILE_SIZE("200700", "上传的文件大小错误：请上传{0}文件"),

    FAIL_DUPLICATE_CHECK("444999","请勿重复提交")
    ;


    String code;
    String msg;

    RespCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
