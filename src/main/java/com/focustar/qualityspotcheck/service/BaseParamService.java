package com.focustar.qualityspotcheck.service;

import com.focustar.qualityspotcheck.pojo.vo.BaseParamVO;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/17
 * description:
 */
public interface BaseParamService {

    List<BaseParamVO> getAllBaseParams();

    boolean updateBaseParam(Integer paramId,boolean status);
}
