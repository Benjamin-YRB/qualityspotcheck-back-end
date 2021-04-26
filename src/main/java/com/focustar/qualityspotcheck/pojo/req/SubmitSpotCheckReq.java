package com.focustar.qualityspotcheck.pojo.req;

import lombok.Data;

/**
 * @Author: Benjamin.Yang
 * @Since: 2021/4/25 下午11:09
 * Description:提交抽检工单请求
 */
@Data
public class SubmitSpotCheckReq {
    private Integer id;
    private Boolean pass;
}
