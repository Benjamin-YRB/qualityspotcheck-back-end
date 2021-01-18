package com.focustar.qualityspotcheck.pojo.vo;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/17
 * description:
 */
public class BaseParamVO {
    private Integer id;
    private String name;
    private String type;
    private String unit;
    private Character status;

    @Override
    public String toString() {
        return "BaseParamsVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                ", status=" + status +
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
