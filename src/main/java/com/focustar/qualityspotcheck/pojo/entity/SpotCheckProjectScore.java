package com.focustar.qualityspotcheck.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: Benjamin.Yang
 * @Since: 2021/4/24 上午12:27
 * Description: 抽检工单基础项目得分详情对象
 */
@Data
public class SpotCheckProjectScore {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer score;
    private boolean pass;
    private Integer spotCheckId;
    private boolean delFlag;
    private Integer level;
    private String parentName;
}
