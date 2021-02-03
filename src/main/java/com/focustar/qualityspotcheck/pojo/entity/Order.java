package com.focustar.qualityspotcheck.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/2
 * description: 工单实体类
 */
@TableName("t_order")
@Data
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 话务员id
     */
    private Integer userId;

    /**
     * 话务员名称
     */
    private String userName;

    private String recordPath;

    private LocalDateTime ringTime;

    private LocalDateTime acceptTime;

    private LocalDateTime endTime;

    private String comeFrom;

    private String callingNo;

    private Integer createBy;

    private LocalDate createTime;

    private Integer updateBy;

    private LocalDate updateTime;


}
