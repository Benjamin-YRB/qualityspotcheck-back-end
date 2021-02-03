package com.focustar.qualityspotcheck.pojo.vo;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/1
 * description: 抽检模板视图对象
 */
public class TemplateVO {
    private Integer id;
    private String name;
    private String creator;
    private LocalDate createTime;
    private LocalDate beginTime;
    private LocalDate endTime;
    private List<String> persons;
    private List<String> projects;
    private Integer passScore;
    private Boolean isAverage;

    @Override
    public String toString() {
        return "TemplateVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", persons=" + persons +
                ", projects=" + projects +
                ", passScore=" + passScore +
                ", isAverage=" + isAverage +
                '}';
    }

    public Boolean getAverage() {
        return isAverage;
    }

    public void setAverage(Boolean average) {
        isAverage = average;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public LocalDate getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDate beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public List<String> getPersons() {
        return persons;
    }

    public void setPersons(List<String> persons) {
        this.persons = persons;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }
}
