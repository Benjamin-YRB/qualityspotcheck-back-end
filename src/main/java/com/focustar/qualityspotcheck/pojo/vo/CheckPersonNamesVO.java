package com.focustar.qualityspotcheck.pojo.vo;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/28
 * description: 添加抽检模板时
 */
public class CheckPersonNamesVO {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "CheckPersonNamesVO{" +
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
