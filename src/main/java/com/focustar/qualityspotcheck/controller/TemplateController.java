package com.focustar.qualityspotcheck.controller;

import com.focustar.qualityspotcheck.commom.enums.RespCode;
import com.focustar.qualityspotcheck.commom.resp.Response;
import com.focustar.qualityspotcheck.commom.util.RedisUtil;
import com.focustar.qualityspotcheck.controller.base.BaseController;
import com.focustar.qualityspotcheck.pojo.req.AddQualityTemplateReq;
import com.focustar.qualityspotcheck.pojo.req.GenerateSpotCheckListReq;
import com.focustar.qualityspotcheck.pojo.req.MatchOrderReq;
import com.focustar.qualityspotcheck.pojo.vo.*;
import com.focustar.qualityspotcheck.service.QualityTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/28
 * description:
 */
@RestController
public class TemplateController extends BaseController {

    public static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    QualityTemplateService qualityTemplateService;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/checkNames")
    public Response<List<CheckPersonNamesVO>> getCheckPerson(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,@DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate dateEnd){
        logger.info("获取指定时间段内有工单的话务员");
        if (dateStart.isAfter(dateEnd)){
            return new Response<>(RespCode.DATE_ERROR);
        }
        return new Response<>(qualityTemplateService.getCheckNames(dateStart,dateEnd),RespCode.SUCCESS);
    }

    @PostMapping("/qualityTemplate")
    public Response<Boolean> addQualityTemplate(@RequestBody @Valid AddQualityTemplateReq req){
        logger.info("添加抽检模板");

        return new Response<>(qualityTemplateService.addTemplate(req,(LoginVO) RedisUtil.getRedis(redisTemplate, RedisUtil.LOGIN_TOKEN_KEY + request.getHeader("token"))),RespCode.SUCCESS);
    }

    @PostMapping("/matchOrder")
    public Response<Integer> matchOrderNum(@RequestBody @Valid MatchOrderReq req){
        logger.info("开始匹配工单数量");
        return new Response<>(qualityTemplateService.matchOrder(req),RespCode.SUCCESS);
    }

    @GetMapping("/qualityTemplates")
    public Response<List<TemplateVO>> getAllTemplates(){
        logger.info("根据当前登录用户权限返回抽检模板");

        return new Response<>(qualityTemplateService.getAllTemplates((LoginVO) RedisUtil.getRedis(redisTemplate,RedisUtil.LOGIN_TOKEN_KEY+request.getHeader("token"))),RespCode.SUCCESS);
    }

    @DeleteMapping("/qualityTemplate/{id}")
    public Response<Boolean> deleteTemplate(@PathVariable("id") Integer id){
        logger.info("删除id为"+id+"的抽检模板");

        return new Response<>(qualityTemplateService.deleteTemplate(id,(LoginVO) RedisUtil.getRedis(redisTemplate,RedisUtil.LOGIN_TOKEN_KEY+request.getHeader("token"))),RespCode.SUCCESS);
    }

    @GetMapping("/useTemplate/{id}")
    public Response<UseTemplateResultVO> useTemplate(@PathVariable("id") Integer id){
        logger.info("使用id为"+id+"的模板生成抽检工单");

        return new Response<>(qualityTemplateService.useTemplate(id,(LoginVO) RedisUtil.getRedis(redisTemplate,RedisUtil.LOGIN_TOKEN_KEY+request.getHeader("token"))),RespCode.SUCCESS);
    }

    /**
     * 使用模板之后生成抽检列表
     * @return
     */
    @PostMapping("spotCheckList")
    public Response<Boolean> generateSpotCheckList(@RequestBody @Valid GenerateSpotCheckListReq req){
        logger.info("生成模板id为"+req.getTempId()+"，抽检工单id为："+req.getSpotIds()+"的抽检列表");

        return new Response<>(qualityTemplateService.generateSpotCheckList(req,(LoginVO) RedisUtil.getRedis(redisTemplate,RedisUtil.LOGIN_TOKEN_KEY+request.getHeader("token"))),RespCode.SUCCESS);
    }
}
