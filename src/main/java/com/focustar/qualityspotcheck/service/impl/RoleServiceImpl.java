package com.focustar.qualityspotcheck.service.impl;

import com.focustar.qualityspotcheck.mapper.RoleMapper;
import com.focustar.qualityspotcheck.pojo.entity.SysRole;
import com.focustar.qualityspotcheck.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yangxiansheng
 * @Since 2021/1/13
 * description:
 */
@Service
public class RoleServiceImpl implements RoleService {



    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<String> getRoleNamesByUserId(Integer userId) {
        roleMapper.getRoleNamesByUserId(userId);
        return null;
    }
}
