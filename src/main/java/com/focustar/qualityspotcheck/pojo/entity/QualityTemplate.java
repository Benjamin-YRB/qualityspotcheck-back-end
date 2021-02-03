package com.focustar.qualityspotcheck.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/28
 * description:
 */
@TableName("quality_temp")
public class QualityTemplate {

    @TableId(type = IdType.AUTO)
    private Integer id ;

    /** 模板名称 */
    private String name ;
    /** 时间段—开始时间 */
    private LocalDate beginTime ;
    /** 时间段—结束时间 */
    private LocalDate endTime ;
    /** 合格分数 */
    private Integer passScore ;
    /** 呼入次数—最小次数 */
    private Integer callInMinTimes ;
    /** 呼入次数—最大次数 */
    private Integer callInMaxTimes ;
    /** 异常次数—最小次数 */
    private Integer exceptionMinTimes ;
    /** 异常次数—最大次数 */
    private Integer exceptionMaxTimes ;
    /** 拒绝次数—最小次数 */
    private Integer refuseMinTimes ;
    /** 拒绝次数—最大次数 */
    private Integer refuseMaxTimes ;
    /** 呼损率—最小值 */
    private Double callFailMinPrecent ;
    /** 呼损率—最大值 */
    private Double callFailMaxPrecent ;
    /** 回访率—最小值 */
    private Double callReturnMinPrecent ;
    /** 回访率—最大值 */
    private Double callReturnMaxPrecent ;
    /** 来电时长—最小值 */
    private Integer callInMinTimeLong ;
    /** 来电时长—最大值 */
    private Integer callInMaxTimeLong ;
    /** 回访时长—最小值 */
    private Integer callReturnMinTimeLong ;
    /** 回访时长—最大值 */
    private Integer callReturnMaxTimeLong ;
    /** 回访次数—最小次数 */
    private Integer callReturnMinTimes ;
    /** 回访次数—最大次数 */
    private Integer callReturnMaxTimes ;
    /** 工单时效，1、特急，2、紧急，3、一般 */
    private String orderPres ;
    /** 是否超时，1、未超时，2、已超时 */
    private String overTime ;
    /** 工单来源，1、96166工单，2、12345系统工单，3、微信工单，4、在线客服工单，5、转接工单，6、12345电话工单，7、数字城管，8、网站，9、其他 */
    private String orderRescource ;
    /** 工单状态，字典：key_qsys_orderstatus */
    private String orderStatus ;
    /** 选择数量 */
    private Integer selectNum ;
    /** 是否平均，1=平均，0=不人均 */
    private Boolean isAverage ;
    /** 结单类型，字典：key_qsys_orderclose 1=结单，2=未结单 */
    private String closeOrderType ;
    /** 创建者 */
    private Integer createBy ;
    /** 创建时间 */
    private LocalDateTime createTime ;

    private Integer checkPersonNum;

    @Override
    public String toString() {
        return "QualityTemplate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", passScore=" + passScore +
                ", callInMinTimes=" + callInMinTimes +
                ", callInMaxTimes=" + callInMaxTimes +
                ", exceptionMinTimes=" + exceptionMinTimes +
                ", exceptionMaxTimes=" + exceptionMaxTimes +
                ", refuseMinTimes=" + refuseMinTimes +
                ", refuseMaxTimes=" + refuseMaxTimes +
                ", callFailMinPrecent=" + callFailMinPrecent +
                ", callFailMaxPrecent=" + callFailMaxPrecent +
                ", callReturnMinPrecent=" + callReturnMinPrecent +
                ", callReturnMaxPrecent=" + callReturnMaxPrecent +
                ", callInMinTimeLong=" + callInMinTimeLong +
                ", callInMaxTimeLong=" + callInMaxTimeLong +
                ", callReturnMinTimeLong=" + callReturnMinTimeLong +
                ", callReturnMaxTimeLong=" + callReturnMaxTimeLong +
                ", callReturnMinTimes=" + callReturnMinTimes +
                ", callReturnMaxTimes=" + callReturnMaxTimes +
                ", orderPres='" + orderPres + '\'' +
                ", overTime='" + overTime + '\'' +
                ", orderRescource='" + orderRescource + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", selectNum=" + selectNum +
                ", isAverage=" + isAverage +
                ", closeOrderType='" + closeOrderType + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", checkPersonNum=" + checkPersonNum +
                ", lastUpdateBy=" + lastUpdateBy +
                ", lastUpdateTime=" + lastUpdateTime +
                ", delFlag=" + delFlag +
                '}';
    }

    public Integer getCheckPersonNum() {
        return checkPersonNum;
    }

    public void setCheckPersonNum(Integer checkPersonNum) {
        this.checkPersonNum = checkPersonNum;
    }

    private Integer lastUpdateBy;
    /** 最后修改时间 */
    private LocalDateTime lastUpdateTime ;
    /**  */
    private Boolean delFlag ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDate beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Integer getCallInMinTimes() {
        return callInMinTimes;
    }

    public void setCallInMinTimes(Integer callInMinTimes) {
        this.callInMinTimes = callInMinTimes;
    }

    public Integer getCallInMaxTimes() {
        return callInMaxTimes;
    }

    public void setCallInMaxTimes(Integer callInMaxTimes) {
        this.callInMaxTimes = callInMaxTimes;
    }

    public Integer getExceptionMinTimes() {
        return exceptionMinTimes;
    }

    public void setExceptionMinTimes(Integer exceptionMinTimes) {
        this.exceptionMinTimes = exceptionMinTimes;
    }

    public Integer getExceptionMaxTimes() {
        return exceptionMaxTimes;
    }

    public void setExceptionMaxTimes(Integer exceptionMaxTimes) {
        this.exceptionMaxTimes = exceptionMaxTimes;
    }

    public Integer getRefuseMinTimes() {
        return refuseMinTimes;
    }

    public void setRefuseMinTimes(Integer refuseMinTimes) {
        this.refuseMinTimes = refuseMinTimes;
    }

    public Integer getRefuseMaxTimes() {
        return refuseMaxTimes;
    }

    public void setRefuseMaxTimes(Integer refuseMaxTimes) {
        this.refuseMaxTimes = refuseMaxTimes;
    }

    public Double getCallFailMinPrecent() {
        return callFailMinPrecent;
    }

    public void setCallFailMinPrecent(Double callFailMinPrecent) {
        this.callFailMinPrecent = callFailMinPrecent;
    }

    public Double getCallFailMaxPrecent() {
        return callFailMaxPrecent;
    }

    public void setCallFailMaxPrecent(Double callFailMaxPrecent) {
        this.callFailMaxPrecent = callFailMaxPrecent;
    }

    public Double getCallReturnMinPrecent() {
        return callReturnMinPrecent;
    }

    public void setCallReturnMinPrecent(Double callReturnMinPrecent) {
        this.callReturnMinPrecent = callReturnMinPrecent;
    }

    public Double getCallReturnMaxPrecent() {
        return callReturnMaxPrecent;
    }

    public void setCallReturnMaxPrecent(Double callReturnMaxPrecent) {
        this.callReturnMaxPrecent = callReturnMaxPrecent;
    }

    public Integer getCallInMinTimeLong() {
        return callInMinTimeLong;
    }

    public void setCallInMinTimeLong(Integer callInMinTimeLong) {
        this.callInMinTimeLong = callInMinTimeLong;
    }

    public Integer getCallInMaxTimeLong() {
        return callInMaxTimeLong;
    }

    public void setCallInMaxTimeLong(Integer callInMaxTimeLong) {
        this.callInMaxTimeLong = callInMaxTimeLong;
    }

    public Integer getCallReturnMinTimeLong() {
        return callReturnMinTimeLong;
    }

    public void setCallReturnMinTimeLong(Integer callReturnMinTimeLong) {
        this.callReturnMinTimeLong = callReturnMinTimeLong;
    }

    public Integer getCallReturnMaxTimeLong() {
        return callReturnMaxTimeLong;
    }

    public void setCallReturnMaxTimeLong(Integer callReturnMaxTimeLong) {
        this.callReturnMaxTimeLong = callReturnMaxTimeLong;
    }

    public Integer getCallReturnMinTimes() {
        return callReturnMinTimes;
    }

    public void setCallReturnMinTimes(Integer callReturnMinTimes) {
        this.callReturnMinTimes = callReturnMinTimes;
    }

    public Integer getCallReturnMaxTimes() {
        return callReturnMaxTimes;
    }

    public void setCallReturnMaxTimes(Integer callReturnMaxTimes) {
        this.callReturnMaxTimes = callReturnMaxTimes;
    }

    public String getOrderPres() {
        return orderPres;
    }

    public void setOrderPres(String orderPres) {
        this.orderPres = orderPres;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getOrderRescource() {
        return orderRescource;
    }

    public void setOrderRescource(String orderRescource) {
        this.orderRescource = orderRescource;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(Integer selectNum) {
        this.selectNum = selectNum;
    }

    public Boolean getAverage() {
        return isAverage;
    }

    public void setAverage(Boolean average) {
        isAverage = average;
    }

    public String getCloseOrderType() {
        return closeOrderType;
    }

    public void setCloseOrderType(String closeOrderType) {
        this.closeOrderType = closeOrderType;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
