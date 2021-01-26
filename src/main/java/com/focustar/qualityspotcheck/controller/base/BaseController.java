package com.focustar.qualityspotcheck.controller.base;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author yangxiansheng
 * @Since 2021/1/12
 * description:
 */
public class BaseController {

    @Autowired
    protected HttpServletRequest request;

}
