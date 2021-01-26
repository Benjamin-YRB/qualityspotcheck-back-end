package com.focustar.qualityspotcheck.service;

import com.focustar.qualityspotcheck.pojo.req.AddBaseProjectReq;
import com.focustar.qualityspotcheck.pojo.vo.BaseProjectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/19
 * description:
 */
public interface BaseProjectService {
    List<BaseProjectVO> getAllBaseProjects();

    boolean addProject( Integer userId, AddBaseProjectReq req);
}
