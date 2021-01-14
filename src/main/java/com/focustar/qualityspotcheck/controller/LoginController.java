package com.focustar.qualityspotcheck.controller;

import com.focustar.qualityspotcheck.commom.enums.LoginCode;
import com.focustar.qualityspotcheck.commom.resp.Response;
import com.focustar.qualityspotcheck.controller.base.BaseController;
import com.focustar.qualityspotcheck.pojo.req.LoginReq;
import com.focustar.qualityspotcheck.pojo.vo.LoginVO;
import com.focustar.qualityspotcheck.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yangxiansheng
 * @Since 2021/1/12
 * description:
 */
@RestController
@CrossOrigin
public class LoginController extends BaseController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Response<LoginVO> login(@RequestBody LoginReq loginReq/*@RequestParam("username") String loginName, @RequestParam("password") String password*/){
        System.out.println(loginReq);
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginReq.getLoginName(),loginReq.getPassword());

        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            return new Response<>(LoginCode.LOGIN_FAIL);
        }

        LoginVO loginVO = userService.loginSuccessResult(loginReq.getLoginName());

        return new Response<>(loginVO, LoginCode.LOGIN_SUCCESS);
    }
}
