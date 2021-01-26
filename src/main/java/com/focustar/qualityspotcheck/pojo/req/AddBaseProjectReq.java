package com.focustar.qualityspotcheck.pojo.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/26
 * description:
 */
public class AddBaseProjectReq {
    @NotNull(message = "父级id不可为空")
    private Integer parentId;

    @NotBlank(message = "名称不可为空")
    private String name;

    @NotNull(message = "级别不可为空")
    private Integer level;

    @NotNull(message = "分数不可为空")
    private Integer score;

    @Override
    public String toString() {
        return "AddBaseProjectReq{" +
                "parentId=" + parentId +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", score=" + score +
                '}';
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
