package com.focustar.qualityspotcheck.pojo.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/4
 * description:
 */
@Data
public class SpotCheckListVO {
    private Integer id;
    private String name;
    /**
     * 质检员名称，谁创建的列表谁就是质检员
     */
    private String operator;

    @DateTimeFormat(pattern = "yyyy-Mm-dd")
    private LocalDateTime createTime;

    @DateTimeFormat(pattern = "yyyy-Mm-dd")
    private LocalDateTime beginTime;

    @DateTimeFormat(pattern = "yyyy-Mm-dd")
    private LocalDateTime endTime;
    /**
     * 列表状态，是否上报
     */
    private Boolean status;
}
