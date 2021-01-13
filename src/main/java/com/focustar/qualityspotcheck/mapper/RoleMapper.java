package com.focustar.qualityspotcheck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.focustar.qualityspotcheck.pojo.entity.SysRole;

/**
 * @Author yangxiansheng
 * @Since 2021/1/13
 * description:
 */
public interface RoleMapper extends BaseMapper<SysRole> {
    SysRole getRoleByUserId(Integer userId);
}
