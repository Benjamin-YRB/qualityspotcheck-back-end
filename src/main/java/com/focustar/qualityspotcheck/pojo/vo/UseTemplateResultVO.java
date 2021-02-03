package com.focustar.qualityspotcheck.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/2
 * description:
 */
@Data
public class UseTemplateResultVO {
    private Integer total;
    private Integer num;
    private List<SpotCheckVO> checkVOS;

}
