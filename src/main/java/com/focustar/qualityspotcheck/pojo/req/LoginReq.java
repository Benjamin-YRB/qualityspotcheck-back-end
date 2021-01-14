package com.focustar.qualityspotcheck.pojo.req;

/**
 * @Author yangxiansheng
 * @Since 2021/1/13
 * description: 登陆接口请求对象
 */
public class LoginReq {
    private String loginName;
    private String password;

    @Override
    public String toString() {
        return "LoginReq{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
