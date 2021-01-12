package com.focustar.qualityspotcheck.controller;

import com.focustar.qualityspotcheck.commom.resp.Response;
import com.focustar.qualityspotcheck.pojo.vo.LoginVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yangxiansheng
 * @Since 2021/1/12
 * description:
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    public Response<LoginVO> login(String loginName,String password){

        return null;
    }
}
