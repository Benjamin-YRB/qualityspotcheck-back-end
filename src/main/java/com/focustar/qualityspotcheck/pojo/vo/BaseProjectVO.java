package com.focustar.qualityspotcheck.pojo.vo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/19
 * description:
 */
public class BaseProjectVO {

    private Integer id;
    private String name;
    private Integer level;
    private Integer score;
    private LocalDateTime createTime;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BaseProjectVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", score=" + score +
                ", createTime=" + createTime +
                ", children=" + children +
                '}';
    }

    List<BaseProjectVO> children;

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

    public List<BaseProjectVO> getChildren() {
        return children;
    }

    public void setChildren(List<BaseProjectVO> children) {
        this.children = children;
    }
}