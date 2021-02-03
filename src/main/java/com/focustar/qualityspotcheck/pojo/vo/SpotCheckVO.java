package com.focustar.qualityspotcheck.pojo.vo;

import lombok.Data;

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
    private LocalDateTime ringTime;
    private LocalDateTime endTime;
    private LocalDateTime acceptTime;
}
