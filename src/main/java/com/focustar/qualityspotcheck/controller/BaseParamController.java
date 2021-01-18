package com.focustar.qualityspotcheck.controller;

import com.focustar.qualityspotcheck.commom.enums.RespCode;
import com.focustar.qualityspotcheck.commom.resp.Response;
import com.focustar.qualityspotcheck.pojo.vo.BaseParamVO;
import com.focustar.qualityspotcheck.service.BaseParamService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/15
 * description:
 */
@RestController
public class BaseParamController {

    public static final Logger logger = LoggerFactory.getLogger(BaseParamController.class);

    @Autowired
    BaseParamService baseParamService;

    @GetMapping("/baseParams")
    @RequiresRoles({"SYSTEM_MANAGER","QUALITY_CHECK_SUPERVISOR"})
    public Response<List<BaseParamVO>> getAllBaseParams(){
        logger.info("获取所有基础参数");

        return new Response<>(baseParamService.getAllBaseParams(), RespCode.SUCCESS);
    }

}
