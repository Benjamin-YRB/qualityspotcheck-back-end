package com.focustar.qualityspotcheck.commom.resp;

/**
 * @Author yangxiansheng
 * @Since 2021/1/12
 * description:
 */
public interface IRespCode {
    public static final String SUCCESS_CODE = "0000000";

    public String getCode();
    public String getMsg();
}
