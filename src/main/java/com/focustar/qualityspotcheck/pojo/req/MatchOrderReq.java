package com.focustar.qualityspotcheck.pojo.req;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/29
 * description: 创建模板时根据模板条件匹配工单数量请求
 */
public class MatchOrderReq {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate end;

    @Override
    public String toString() {
        return "MatchOrderReq{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
