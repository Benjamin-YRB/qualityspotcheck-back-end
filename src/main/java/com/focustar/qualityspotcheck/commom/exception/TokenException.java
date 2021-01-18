package com.focustar.qualityspotcheck.commom.exception;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/16
 * description:
 */
public class TokenException  extends RuntimeException{
    private String code;
    private String errorMessage;

    @Override
    public String toString() {
        return "TokenException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public TokenException() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public TokenException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
