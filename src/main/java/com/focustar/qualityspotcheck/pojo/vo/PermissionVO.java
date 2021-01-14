package com.focustar.qualityspotcheck.pojo.vo;

import java.util.List;

/**
 * @Author yangxiansheng
 * @Since 2021/1/14
 * description:
 */
public class PermissionVO {

    private Integer id;
    private String title;
    private String index;
    private String icon;
    private String resType;
    private List<PermissionVO> subs;

    @Override
    public String toString() {
        return "PermissionVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", index='" + index + '\'' +
                ", icon='" + icon + '\'' +
                ", resType='" + resType + '\'' +
                ", subs=" + subs +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
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

    public List<PermissionVO> getSubs() {
        return subs;
    }

    public void setSubs(List<PermissionVO> subs) {
        this.subs = subs;
    }
}
