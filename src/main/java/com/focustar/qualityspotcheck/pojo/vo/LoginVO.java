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

    private SysUser user;
    private SysRole role;

    //动态菜单路由
    private List<PermissionVO> item;

    @Override
    public String toString() {
        return "LoginVO{" +
                "user=" + user +
                ", role=" + role +
                ", item=" + item +
                '}';
    }

    public List<PermissionVO> getItem() {
        return item;
    }

    public void setItem(List<PermissionVO> item) {
        this.item = item;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

}
