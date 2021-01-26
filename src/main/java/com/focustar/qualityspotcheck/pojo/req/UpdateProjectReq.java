package com.focustar.qualityspotcheck.pojo.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/26
 * description:
 */
public class UpdateProjectReq {
    @NotNull(message = "更新项目的id不可为空")
    private Integer id;

    @NotBlank(message = "更新项目的name不可为空")
    private String name;

    private Integer level;

    @NotNull(message = "更新项目的score不可为空")
    private Integer score;

    @Override
    public String toString() {
        return "UpdateProjectReq{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", score=" + score +
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
