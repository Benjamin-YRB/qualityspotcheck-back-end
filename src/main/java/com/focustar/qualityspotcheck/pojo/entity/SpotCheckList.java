package com.focustar.qualityspotcheck.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/4
 * description: 抽检列表对象
 */
@Data
public class SpotCheckList {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer tempId;
    private Integer createBy;
    private LocalDateTime createTime;
    private Integer updateBy;
    private LocalDateTime updateTime;
    private boolean delFlag;

    public SpotCheckList(Integer tempId, Integer createBy, LocalDateTime createTime, Integer updateBy, LocalDateTime updateTime, boolean delFlag) {
        this.tempId = tempId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delFlag = delFlag;
    }

    public SpotCheckList() {
    }
}
