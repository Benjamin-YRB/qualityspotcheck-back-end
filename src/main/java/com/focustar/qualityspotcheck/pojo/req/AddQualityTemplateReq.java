package com.focustar.qualityspotcheck.pojo.req;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/29
 * description:
 */
public class AddQualityTemplateReq {

    @NotNull(message = "模板名称不可为空")
    private String name;

    @NotNull(message = "开始日期不可为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginTime;

    @NotNull(message = "结束日期不可为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTime;

    @NotNull(message = "合格分数不可为空")
    private Integer passScore;

    @NotNull(message = "抽检数量不可为空")
    private Integer selectNum;

    @NotNull(message = "是否人均不可为空")
    private Boolean isAverage;

    @NotNull
    private List<Integer> checkPersonIds;

    @NotNull
    private List<Integer> checkProjectIds;

    @Override
    public String toString() {
        return "AddQualityTemplateReq{" +
                "name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", passScore=" + passScore +
                ", selectNum=" + selectNum +
                ", isAverage=" + isAverage +
                ", checkPersonIds=" + checkPersonIds +
                ", checkProjectIds=" + checkProjectIds +
                '}';
    }

    public List<Integer> getCheckPersonIds() {
        return checkPersonIds;
    }

    public void setCheckPersonIds(List<Integer> checkPersonIds) {
        this.checkPersonIds = checkPersonIds;
    }

    public List<Integer> getCheckProjectIds() {
        return checkProjectIds;
    }

    public void setCheckProjectIds(List<Integer> checkProjectIds) {
        this.checkProjectIds = checkProjectIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Integer getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(Integer selectNum) {
        this.selectNum = selectNum;
    }

    public Boolean getAverage() {
        return isAverage;
    }

    public void setAverage(Boolean average) {
        isAverage = average;
    }
}
