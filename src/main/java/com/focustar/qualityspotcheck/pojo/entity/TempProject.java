package com.focustar.qualityspotcheck.pojo.entity;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/30
 * description: 模板和抽检项目关联对象
 */
public class TempProject {
    private Integer id;
    private Integer tempId;
    private Integer ProjectId;

    public TempProject() {
    }

    public TempProject(Integer tempId, Integer projectId) {
        this.tempId = tempId;
        ProjectId = projectId;
    }

    @Override
    public String toString() {
        return "TempProject{" +
                "id=" + id +
                ", tempId=" + tempId +
                ", ProjectId=" + ProjectId +
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

    public Integer getProjectId() {
        return ProjectId;
    }

    public void setProjectId(Integer projectId) {
        ProjectId = projectId;
    }
}

