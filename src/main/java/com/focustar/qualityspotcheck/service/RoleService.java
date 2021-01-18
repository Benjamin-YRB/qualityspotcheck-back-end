package com.focustar.qualityspotcheck.service;

import com.focustar.qualityspotcheck.pojo.entity.SysRole;

import java.util.List;

/**
 * @Author yangxiansheng
 * @Since 2021/1/13
 * description:
 */
public interface RoleService {

    List<String> getRoleNamesByUserId(Integer userId);

}
