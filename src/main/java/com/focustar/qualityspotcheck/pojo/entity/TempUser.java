package com.focustar.qualityspotcheck.pojo.entity;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/30
 * description: 模板和抽检人员关联表对象
 */
public class TempUser {
    public TempUser(Integer tempId, Integer userId) {
        this.tempId = tempId;
        this.userId = userId;
    }

    public TempUser() {
    }

    private Integer id;
    private Integer tempId;
    private Integer userId;

    @Override
    public String toString() {
        return "TempUser{" +
                "id=" + id +
                ", tempId=" + tempId +
                ", userId=" + userId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
