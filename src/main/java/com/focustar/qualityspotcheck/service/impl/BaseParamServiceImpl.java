package com.focustar.qualityspotcheck.service.impl;

import com.focustar.qualityspotcheck.mapper.BaseParamMapper;
import com.focustar.qualityspotcheck.pojo.entity.BaseParam;
import com.focustar.qualityspotcheck.pojo.vo.BaseParamVO;
import com.focustar.qualityspotcheck.service.BaseParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/17
 * description:
 */
@Service
public class BaseParamServiceImpl implements BaseParamService {

    public static final Logger logger = LoggerFactory.getLogger(BaseParamServiceImpl.class);

    @Autowired
    BaseParamMapper baseParamMapper;

    @Override
    public List<BaseParamVO> getAllBaseParams() {
        return baseParamMapper.getAllBaseParamVO();
    }

    @Override
    public boolean updateBaseParam(Integer paramId, boolean status) {
        return baseParamMapper.updateStatus(paramId,status);
    }
}
