package com.focustar.qualityspotcheck.pojo.req;

import lombok.Data;

import java.util.List;

/**
 * @Author: Benjamin.Yang
 * @Since: 2021/4/26 上午12:20
 * Description:
 */
@Data
public class SubmitSpotCheckReqs {
    private List<SubmitSpotCheckReq> list;
}
