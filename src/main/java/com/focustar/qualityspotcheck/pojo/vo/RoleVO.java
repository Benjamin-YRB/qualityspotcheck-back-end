package com.focustar.qualityspotcheck.pojo.vo;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/22
 * description:
 */
public class RoleVO {
    private Integer id;
    private String name;
    private String roleCode;
    private Integer priority;

    @Override
    public String toString() {
        return "RoleVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", priority=" + priority +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
