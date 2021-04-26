package com.focustar.qualityspotcheck.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: Benjamin.Yang
 * @Since: 2021/4/25 下午7:03
 * Description:
 */
@Data
public class SpotCheckExVos {
    private List<SpotCheckProjectVO> list;
    private Integer passScore;
}
