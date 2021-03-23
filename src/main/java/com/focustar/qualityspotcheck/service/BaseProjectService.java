package com.focustar.qualityspotcheck.service;

import com.focustar.qualityspotcheck.pojo.req.AddProjectReq;
import com.focustar.qualityspotcheck.pojo.req.UpdateProjectReq;
import com.focustar.qualityspotcheck.pojo.vo.BaseProjectVO;
import com.focustar.qualityspotcheck.pojo.vo.SpotCheckProjectVO;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/19
 * description:
 */
public interface BaseProjectService {
    List<BaseProjectVO> getAllBaseProjects();

    boolean addProject( Integer userId, AddProjectReq req);

    boolean deleteProject(Integer userId, Integer id);

    boolean updateProject(Integer userId, UpdateProjectReq req);


    List<SpotCheckProjectVO> getProjectsByCheckOrderId(Integer id);
}
