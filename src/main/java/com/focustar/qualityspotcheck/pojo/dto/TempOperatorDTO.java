package com.focustar.qualityspotcheck.pojo.dto;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/2
 * description: 模板关联话务员数据传输对象
 */
public class TempOperatorDTO {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "TempOperatorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
}
