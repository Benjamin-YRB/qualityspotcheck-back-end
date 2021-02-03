package com.focustar.qualityspotcheck.service;

import com.focustar.qualityspotcheck.pojo.req.AddQualityTemplateReq;
import com.focustar.qualityspotcheck.pojo.req.MatchOrderReq;
import com.focustar.qualityspotcheck.pojo.vo.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/28
 * description:
 */
public interface QualityTemplateService {
    List<CheckPersonNamesVO> getCheckNames(LocalDate start, LocalDate end);

    Integer matchOrder(MatchOrderReq req);

    boolean addTemplate(AddQualityTemplateReq req, LoginVO loginVO);

    List<TemplateVO> getAllTemplates(LoginVO loginVO);

    boolean deleteTemplate(Integer id,LoginVO loginVO);

    UseTemplateResultVO useTemplate(Integer id, LoginVO loginVO);
}
