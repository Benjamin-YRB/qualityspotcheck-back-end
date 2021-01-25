package com.focustar.qualityspotcheck.controller;

import com.focustar.qualityspotcheck.commom.enums.RespCode;
import com.focustar.qualityspotcheck.commom.resp.Response;
import com.focustar.qualityspotcheck.controller.base.BaseController;
import com.focustar.qualityspotcheck.pojo.entity.BaseProject;
import com.focustar.qualityspotcheck.pojo.vo.BaseProjectVO;
import com.focustar.qualityspotcheck.service.BaseProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/19
 * description:
 */
@RestController
public class BaseProjectController extends BaseController {

    Logger logger = LoggerFactory.getLogger(BaseProject.class);

    @Autowired
    BaseProjectService baseProjectService;

    @GetMapping("/baseProjects")
    public Response<List<BaseProjectVO>> getAllBaseProject(){

        logger.info("开始获取所有基础项");

        return new Response<>(baseProjectService.getAllBaseProjects(), RespCode.SUCCESS);
    }

}
