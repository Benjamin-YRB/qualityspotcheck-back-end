package com.focustar.qualityspotcheck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.focustar.qualityspotcheck.pojo.entity.SysPermission;

import java.util.List;

/**
 * @Author yangxiansheng
 * @Since 2021/1/13
 * description:
 */
public interface PermissionMapper extends BaseMapper<SysPermission> {

    List<SysPermission> getPermissionsByUserId(Integer userId);

}
