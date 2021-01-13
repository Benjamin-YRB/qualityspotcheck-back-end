package com.focustar.qualityspotcheck.commom.enums;

import com.focustar.qualityspotcheck.commom.resp.IRespCode;

/**
 * @Author yangxiansheng
 * @Since 2021/1/13
 * description:
 */
public enum LoginCode implements IRespCode {
    LOGIN_SUCCESS("000000","登陆成功"),
    LOGIN_FAIL("100000","用户名或密码错误！")
    ;
    String code;
    String msg;

    LoginCode(String code, String msg) {
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
