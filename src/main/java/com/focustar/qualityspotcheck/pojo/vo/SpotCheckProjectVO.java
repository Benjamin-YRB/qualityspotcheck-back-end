package com.focustar.qualityspotcheck.pojo.vo;

import lombok.Data;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/9
 * description: 抽检细节视图对象
 */
@Data
public class SpotCheckProjectVO {
    private Integer id;
    private String parentName;
    private String name;
    private Integer score;
    private Integer level;
    private boolean pass;
}
