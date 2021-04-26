package com.focustar.qualityspotcheck.controller;

import com.focustar.qualityspotcheck.commom.enums.LoginCode;
import com.focustar.qualityspotcheck.commom.resp.Response;
import com.focustar.qualityspotcheck.commom.util.RedisUtil;
import com.focustar.qualityspotcheck.controller.base.BaseController;
import com.focustar.qualityspotcheck.pojo.req.LoginReq;
import com.focustar.qualityspotcheck.pojo.vo.LoginVO;
import com.focustar.qualityspotcheck.service.UserService;
import net.sf.jsqlparser.statement.select.KSQLJoinWindow;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/12
 * description:
 */
@RestController
@CrossOrigin
public class LoginController extends BaseController {

    public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("/login")
    public Response<LoginVO> login(@RequestBody @Valid LoginReq loginReq){
        logger.info(loginReq.getLoginName());
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginReq.getLoginName(),loginReq.getPassword());
        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            return new Response<>(LoginCode.LOGIN_FAIL);
        }
        LoginVO loginVO = userService.loginSuccessResult(loginReq.getLoginName());
        loginVO.setToken(UUID.randomUUID().toString());
        RedisUtil.setRedis(redisTemplate,RedisUtil.LOGIN_TOKEN_KEY+loginVO.getToken(),loginVO,RedisUtil.LOGIN_TOKEN_ALIVE_TIME, TimeUnit.DAYS);
        logger.info("缓存当前登陆用户信息成功:"+loginVO);
        logger.info("登陆成功，"+loginVO.getUser().getName());
        return new Response<>(loginVO, LoginCode.LOGIN_SUCCESS);
    }
}
