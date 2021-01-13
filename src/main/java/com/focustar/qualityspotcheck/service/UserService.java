package com.focustar.qualityspotcheck.service;

import com.focustar.qualityspotcheck.pojo.entity.SysUser;
import com.focustar.qualityspotcheck.pojo.vo.LoginVO;

/**
 * @Author yangxiansheng
 * @Since 2021/1/11
 * description:
 */
public interface UserService {
    SysUser getUserByLoginName(String loginName);

    LoginVO loginSuccessResult(String loginName);
}
