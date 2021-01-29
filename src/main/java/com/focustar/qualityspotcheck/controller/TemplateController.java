package com.focustar.qualityspotcheck.controller;

import com.focustar.qualityspotcheck.commom.enums.RespCode;
import com.focustar.qualityspotcheck.commom.resp.Response;
import com.focustar.qualityspotcheck.mapper.QualityTemplateMapper;
import com.focustar.qualityspotcheck.pojo.req.AddQualityTemplateReq;
import com.focustar.qualityspotcheck.pojo.req.MatchOrderReq;
import com.focustar.qualityspotcheck.pojo.vo.CheckPersonNamesVO;
import com.focustar.qualityspotcheck.service.QualityTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/28
 * description:
 */
@RestController
public class TemplateController {

    public static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    QualityTemplateService qualityTemplateService;

    @GetMapping("/checkNames")
    public Response<List<CheckPersonNamesVO>> getCheckPerson(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,@DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate dateEnd){
        if (dateStart.isAfter(dateEnd)){
            return new Response<>(RespCode.DATE_ERROR);
        }
        return new Response<>(qualityTemplateService.getCheckNames(dateStart,dateEnd),RespCode.SUCCESS);
    }

    @PostMapping("/qualityTemplate")
    public Response<Boolean> addQualityTemplate(@RequestBody @Valid AddQualityTemplateReq req){
        logger.info("添加抽检模板");
        return new Response<>(false,RespCode.SUCCESS);
    }

    @PostMapping("/matchOrder")
    public Response<Integer> matchOrderNum(@RequestBody @Valid MatchOrderReq req){
        logger.info("开始匹配工单数量");
        return new Response<>(qualityTemplateService.matchOrder(req),RespCode.SUCCESS);
    }
}
