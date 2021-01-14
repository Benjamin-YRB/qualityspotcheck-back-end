package com.focustar.qualityspotcheck.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.focustar.qualityspotcheck.mapper.PermissionMapper;
import com.focustar.qualityspotcheck.mapper.RoleMapper;
import com.focustar.qualityspotcheck.mapper.UserMapper;
import com.focustar.qualityspotcheck.pojo.entity.SysUser;
import com.focustar.qualityspotcheck.pojo.vo.LoginVO;
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
    public SysUser getUserByLoginName(String loginName) {
        return userMapper.selectOne(
                new QueryWrapper<SysUser>()
//                .select("id","login_name","password","name","email","phone","user_type")
                .eq("login_name",loginName)
                .eq("del_flag",0)
        );
    }

    @Override
    public LoginVO loginSuccessResult(String loginName) {
        LoginVO loginVO = new LoginVO();

        SysUser user = getUserByLoginName(loginName);

        //组装对象
        loginVO.setUser(user);
        loginVO.setRole(roleMapper.getRoleByUserId(user.getId()));
        loginVO.setItem(permissionMapper.getPermissionTreeByUserId(user.getId()));

        return loginVO;
    }
}
