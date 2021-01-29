package com.focustar.qualityspotcheck.service.impl;

import com.focustar.qualityspotcheck.mapper.QualityTemplateMapper;
import com.focustar.qualityspotcheck.pojo.req.MatchOrderReq;
import com.focustar.qualityspotcheck.pojo.vo.CheckPersonNamesVO;
import com.focustar.qualityspotcheck.service.QualityTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/28
 * description:
 */
@Service
public class QualityTemplateServiceImpl implements QualityTemplateService {

    @Autowired
    QualityTemplateMapper qualityTemplateMapper;

    @Override
    public List<CheckPersonNamesVO> getCheckNames(LocalDate start, LocalDate end) {

        return qualityTemplateMapper.getCheckNames(start,end);
    }

    @Override
    public Integer matchOrder(MatchOrderReq req) {
        return qualityTemplateMapper.matchOrder(req);
    }
}
