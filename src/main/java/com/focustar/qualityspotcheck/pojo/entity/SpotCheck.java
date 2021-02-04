package com.focustar.qualityspotcheck.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/2
 * description: 生成的待抽检工单
 */
@TableName("spot_check")
@Data
public class SpotCheck implements Serializable,Cloneable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 工单id
     */
    private Integer orderId;
    /**
     * 坐席ID
     */
    private Integer agentId;
    /**
     * 坐席名称
     */
    private String agentName;
    /**
     * 抽检总分数
     */
    private Integer totalScore;
    /**
     * 抽检是否通过  （不通过= 1，通过 = 2）
     */
    private String spotCheckPass;
    /**
     * 电话号码
     */
    private String callingNo;
    /**
     * 质检人ID
     */
    private Integer operationId;
    /**
     * 质检日期
     */
    private LocalDate qualityTime;
    /**
     * 质检状态：0=待质检，1=已质检，2=申请复议，3=复议审核通过，4=复议审核不通过，5=复议完成
     */
    private Integer qualityStatus;
    /**
     * 来电时间
     */
    private LocalDateTime ringTime;
    /**
     * 应答时间
     */
    private LocalDateTime acceptTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
    /**
     * 申请记录id,每次申请只记录一个，审核后清空
     */
    private Integer complainId;

    /**
     * 来源
     */
    private String comeFrom;

    /**
     * 录音路径
     */
    private String recordPath;
    /**
     * 抽检列表id，若该抽检工单被选中生成抽检列表才有值
     */
    private Integer spotCheckListId;
    /**
     *
     */
    private Integer createBy;
    /**
     *
     */
    private LocalDateTime createTime;
    /**
     *
     */
    private Integer updateBy;
    /**
     *
     */
    private LocalDateTime updateTime;
    /**
     *
     */
    private Boolean delFlag;

}