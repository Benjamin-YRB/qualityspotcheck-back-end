package com.focustar.qualityspotcheck.pojo.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/5
 * description: 对抽检列表进行抽检时抽检工单视图对象
 */
@Data
public class SpotCheckExVO extends SpotCheckVO {
    private String recordPth;

    private Boolean isRemark;
    /**
     * 标注内容
     */
    private String remarks;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createTime;
}
