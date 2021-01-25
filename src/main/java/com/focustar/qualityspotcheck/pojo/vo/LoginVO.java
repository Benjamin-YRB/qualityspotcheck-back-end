package com.focustar.qualityspotcheck.pojo.vo;

import com.focustar.qualityspotcheck.pojo.entity.SysRole;
import com.focustar.qualityspotcheck.pojo.entity.SysUser;

import java.util.List;


/**
 * @Author yangxiansheng
 * @Since 2021/1/12
 * description: 登陆成功视图渲染对象
 */
public class LoginVO {
    /**
     * 用户信息
     */
    private UserVO user;
    /**
     * 角色
     */
    private List<RoleVO> roles;

    /**
     * 登陆token
     */
    private String token;
    /**
     * 动态菜单路由
     */
    private List<PermissionVO> item;

    @Override
    public String toString() {
        return "LoginVO{" +
                "user=" + user +
                ", roles=" + roles +
                ", token='" + token + '\'' +
                ", item=" + item +
                '}';
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public List<RoleVO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVO> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<PermissionVO> getItem() {
        return item;
    }

    public void setItem(List<PermissionVO> item) {
        this.item = item;
    }
}
