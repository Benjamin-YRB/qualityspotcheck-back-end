package com.focustar.qualityspotcheck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.focustar.qualityspotcheck.pojo.entity.SysRole;

import java.util.List;

/**
 * @Author yangxiansheng
 * @Since 2021/1/13
 * description:
 */
public interface RoleMapper extends BaseMapper<SysRole> {
    List<SysRole> getRolesByUserId(Integer userId);

    List<String> getRoleNamesByUserId(Integer userId);

}
