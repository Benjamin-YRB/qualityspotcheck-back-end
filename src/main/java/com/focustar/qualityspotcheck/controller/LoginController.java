package com.focustar.qualityspotcheck.controller;

import com.focustar.qualityspotcheck.commom.enums.LoginCode;
import com.focustar.qualityspotcheck.commom.resp.Response;
import com.focustar.qualityspotcheck.controller.base.BaseController;
import com.focustar.qualityspotcheck.pojo.vo.LoginVO;
import com.focustar.qualityspotcheck.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yangxiansheng
 * @Since 2021/1/12
 * description:
 */
@RestController
public class LoginController extends BaseController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Response<LoginVO> login(String loginName,String password){
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName,password);

        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            return new Response<>(LoginCode.LOGIN_FAIL);
        }

        LoginVO loginVO = userService.loginSuccessResult(loginName);

        return new Response<>(loginVO, LoginCode.LOGIN_SUCCESS);
    }
}
