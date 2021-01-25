package com.focustar.qualityspotcheck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.focustar.qualityspotcheck.pojo.entity.SysUser;
import com.focustar.qualityspotcheck.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author yangxiansheng
 * @Since 2021/1/13
 * description:
 */
public interface UserMapper extends BaseMapper<SysUser> {
    UserVO getUserVOByLoginName(String loginName);

    SysUser getSysUserByLoginName(String loginName);
}
