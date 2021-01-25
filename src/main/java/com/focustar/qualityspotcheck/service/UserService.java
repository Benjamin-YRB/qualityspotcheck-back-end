package com.focustar.qualityspotcheck.service;

import com.focustar.qualityspotcheck.pojo.entity.SysUser;
import com.focustar.qualityspotcheck.pojo.vo.LoginVO;
import com.focustar.qualityspotcheck.pojo.vo.UserVO;

/**
 * @Author yangxiansheng
 * @Since 2021/1/11
 * description:
 */
public interface UserService {
    UserVO getUserByLoginName(String loginName);

    SysUser getSysUserByLoginName(String loginName);

    LoginVO loginSuccessResult(String loginName);
}
