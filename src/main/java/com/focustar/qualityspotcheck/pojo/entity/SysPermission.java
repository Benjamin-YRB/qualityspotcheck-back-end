package com.focustar.qualityspotcheck.pojo.entity;

import java.time.LocalDateTime;

/**
 * @Author yangxiansheng
 * @Date 2021/1/11
 * description: 系统权限实体类
 */
public class SysPermission {
    private Integer id;
    private Integer parentId;
    private String title;
    private String permissionIndex;
    private String icon;
    private String resType;
    private Integer createBy;
    private LocalDateTime createTime;
    private Integer updateBy;
    private LocalDateTime updateTime;
    private String remarks;
    private boolean delFlag;
    private Integer salt;

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", title='" + title + '\'' +
                ", permissionIndex='" + permissionIndex + '\'' +
                ", icon='" + icon + '\'' +
                ", resType='" + resType + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", remarks='" + remarks + '\'' +
                ", delFlag=" + delFlag +
                ", salt=" + salt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPermissionIndex() {
        return permissionIndex;
    }

    public void setPermissionIndex(String permissionIndex) {
        this.permissionIndex = permissionIndex;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isDelFlag() {
        return delFlag;
    }

    public void setDelFlag(boolean delFlag) {
        this.delFlag = delFlag;
    }
}
