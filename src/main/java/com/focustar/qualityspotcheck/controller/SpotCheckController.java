package com.focustar.qualityspotcheck.controller;

import com.focustar.qualityspotcheck.commom.enums.RespCode;
import com.focustar.qualityspotcheck.commom.resp.Response;
import com.focustar.qualityspotcheck.commom.util.RedisUtil;
import com.focustar.qualityspotcheck.controller.base.BaseController;
import com.focustar.qualityspotcheck.pojo.req.SpotCheckRemarkReq;
import com.focustar.qualityspotcheck.pojo.req.SubmitSpotCheckReqs;
import com.focustar.qualityspotcheck.pojo.vo.*;
import com.focustar.qualityspotcheck.service.BaseProjectService;
import com.focustar.qualityspotcheck.service.SpotCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/4
 * description: 抽检相关接口
 */
@RestController
public class SpotCheckController extends BaseController {

    public static final Logger logger = LoggerFactory.getLogger(SpotCheckController.class);

    @Autowired
    SpotCheckService spotCheckService;

    @Autowired
    BaseProjectService baseProjectService;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/spotCheckLists")
    public Response<List<SpotCheckListVO>> SpotCheckLists(){
        logger.info("根据当前角色权限获取抽检列表");
        List<SpotCheckListVO> spotCheckListVOS = spotCheckService.getSpotCheckListVOs((LoginVO) RedisUtil.getRedis(redisTemplate, RedisUtil.LOGIN_TOKEN_KEY + request.getHeader("token")));
        return new Response<>(spotCheckListVOS, RespCode.SUCCESS);
    }

    @GetMapping("/spotCheckEx/{id}")
    public Response<List<SpotCheckExVO>> getSpotChecksByListId(@PathVariable("id") Integer id){
        logger.info("根据抽检列表id获取该列表下的抽检工单");

        return new Response<>(spotCheckService.getByListId(id),RespCode.SUCCESS);
    }

//    @GetMapping("/spotCheckEx/{id}")
//    public Response<SpotCheckExVos> getSpotChecksByListId(@PathVariable("id") Integer id){
//        logger.info("根据抽检列表id获取该列表下的抽检工单和合格分数");
//
//        SpotCheckExVos spotCheckExVos = new SpotCheckExVos();
//        spotCheckExVos.setList(spotCheckService.getByListId(id));
//        spotCheckExVos.setPassScore(spotCheckService.getPassScoreBySpotCheckId(id));
//        return new Response<>(spotCheckExVos,RespCode.SUCCESS);
//    }

    /**
     * 根据抽检工单id返回关联的抽检项目
     * @param id
     * @return
     */
    @GetMapping("/spotCheckProject/{id}")
    public Response<SpotCheckExVos> spotCheckItem(@PathVariable("id") Integer id){
        logger.info("获取工单id为"+id+"的详细抽检项目");
        SpotCheckExVos spotCheckExVos = new SpotCheckExVos();
        spotCheckExVos.setList(baseProjectService.getProjectsDetailByCheckOrderId(id));
        spotCheckExVos.setPassScore(spotCheckService.getPassScoreBySpotCheckId(id));
        return new Response<>(spotCheckExVos,RespCode.SUCCESS);
    }

    /**
     * 添加标注
     * @param req
     * @return
     */
    @PutMapping("/spotCheckRemark")
    public Response<Boolean> updateRemarks(@RequestBody SpotCheckRemarkReq req){
        logger.info("标注更新"+req);
        return new Response<>(spotCheckService.updateRemark(req) > 0,RespCode.SUCCESS);
    }

    /**
     * 提交一个抽检工单的抽检结果
     * @param submitSpotCheckReqs
     * @return
     */
    @PostMapping("/submitSpotCheck")
    public Response<Boolean> submit(@RequestBody SubmitSpotCheckReqs submitSpotCheckReqs){
        logger.info("提交抽检工单的抽检结果");

        Response<Boolean> booleanResponse = new Response<>(spotCheckService.submit(submitSpotCheckReqs.getList()), RespCode.SUCCESS);
        return booleanResponse;
    }
}
