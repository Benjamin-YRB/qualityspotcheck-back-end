package com.focustar.qualityspotcheck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.focustar.qualityspotcheck.pojo.entity.BaseProject;
import com.focustar.qualityspotcheck.pojo.req.AddBaseProjectReq;
import com.focustar.qualityspotcheck.pojo.vo.BaseProjectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/19
 * description:
 */
public interface BaseProjectMapper extends BaseMapper<BaseProject> {
    List<BaseProjectVO> getAllBaseProjects();

    boolean addProject(@Param("userId")Integer userId,@Param("req") AddBaseProjectReq req);
}
