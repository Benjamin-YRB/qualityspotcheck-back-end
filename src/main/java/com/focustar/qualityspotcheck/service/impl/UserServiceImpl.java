package com.focustar.qualityspotcheck.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.focustar.qualityspotcheck.mapper.PermissionMapper;
import com.focustar.qualityspotcheck.mapper.RoleMapper;
import com.focustar.qualityspotcheck.mapper.UserMapper;
import com.focustar.qualityspotcheck.pojo.entity.SysUser;
import com.focustar.qualityspotcheck.pojo.vo.LoginVO;
import com.focustar.qualityspotcheck.pojo.vo.UserVO;
import com.focustar.qualityspotcheck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yangxiansheng
 * @Since 2021/1/12
 * description:
 */
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public UserVO getUserByLoginName(String loginName) {
        return userMapper.getUserVOByLoginName(loginName);
    }

    @Override
    public SysUser getSysUserByLoginName(String loginName) {
        return userMapper.getSysUserByLoginName(loginName);
    }

    @Override
    public LoginVO loginSuccessResult(String loginName) {
        LoginVO loginVO = new LoginVO();

        UserVO user = getUserByLoginName(loginName);

        //组装对象
        loginVO.setUser(user);
        loginVO.setRoles(roleMapper.getRolesByUserId(user.getId()));
        loginVO.setItem(permissionMapper.getPermissionTreeByUserId(user.getId()));

        return loginVO;
    }
}
