package com.focustar.qualityspotcheck.pojo.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/2
 * description: 使用抽检模板筛选出的抽检工单视图对象
 */
@Data
public class SpotCheckVO {
    private Integer id;
    private String comeFrom;
    private String callingNo;
    private String agentName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ringTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime acceptTime;
}
