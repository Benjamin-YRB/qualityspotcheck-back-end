package com.focustar.qualityspotcheck.controller;

import com.focustar.qualityspotcheck.commom.enums.RespCode;
import com.focustar.qualityspotcheck.commom.resp.Response;
import com.focustar.qualityspotcheck.commom.util.RedisUtil;
import com.focustar.qualityspotcheck.controller.base.BaseController;
import com.focustar.qualityspotcheck.pojo.entity.BaseProject;
import com.focustar.qualityspotcheck.pojo.req.AddProjectReq;
import com.focustar.qualityspotcheck.pojo.req.UpdateProjectReq;
import com.focustar.qualityspotcheck.pojo.vo.BaseProjectVO;
import com.focustar.qualityspotcheck.pojo.vo.LoginVO;
import com.focustar.qualityspotcheck.service.BaseProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/baseProjects")
    public Response<List<BaseProjectVO>> getAllBaseProject(){
        logger.info("开始获取所有基础项");
        return new Response<>(baseProjectService.getAllBaseProjects(), RespCode.SUCCESS);
    }


    @PostMapping("/baseProject")
    public Response<Boolean> addBaseProject(@RequestBody @Valid AddProjectReq req){
        logger.info("开始添加基础项");

        LoginVO loginVO = (LoginVO) RedisUtil.getRedis(redisTemplate, RedisUtil.LOGIN_TOKEN_KEY + request.getHeader("token"));

        return new Response<>(baseProjectService.addProject(loginVO.getUser().getId(),req),RespCode.SUCCESS);
    }

    @PutMapping("/baseProject")
    public Response<Boolean> updateBaseProject(@RequestBody @Valid UpdateProjectReq req){
        logger.info("更新id为"+req.getId()+"的基础项"+req);

        LoginVO loginVO = (LoginVO) RedisUtil.getRedis(redisTemplate, RedisUtil.LOGIN_TOKEN_KEY + request.getHeader("token"));

        return new Response<>(baseProjectService.updateProject(loginVO.getUser().getId(),req),RespCode.SUCCESS);
    }

    @DeleteMapping("/baseProject/{id}")
    public Response<Boolean> deleteBaseProject(@PathVariable Integer id){
        logger.info("删除id为"+id+"的基础项");

        LoginVO loginVO = (LoginVO) RedisUtil.getRedis(redisTemplate, RedisUtil.LOGIN_TOKEN_KEY + request.getHeader("token"));

        return new Response<>(baseProjectService.deleteProject(loginVO.getUser().getId(),id),RespCode.SUCCESS);
    }
}
