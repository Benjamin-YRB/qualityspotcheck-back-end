package com.focustar.qualityspotcheck.service.impl;

import com.focustar.qualityspotcheck.mapper.BaseProjectMapper;
import com.focustar.qualityspotcheck.pojo.entity.BaseProject;
import com.focustar.qualityspotcheck.pojo.req.AddProjectReq;
import com.focustar.qualityspotcheck.pojo.req.UpdateProjectReq;
import com.focustar.qualityspotcheck.pojo.vo.BaseProjectVO;
import com.focustar.qualityspotcheck.pojo.vo.SpotCheckProjectVO;
import com.focustar.qualityspotcheck.service.BaseProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/19
 * description:
 */
@Service
public class BaseProjectServiceImpl implements BaseProjectService {
    public static final Logger logger = LoggerFactory.getLogger(BaseProjectServiceImpl.class);
    @Autowired
    BaseProjectMapper baseProjectMapper;

    @Override
    public List<BaseProjectVO> getAllBaseProjects() {
        return baseProjectMapper.getAllBaseProjects();
    }

    @Override
    public boolean addProject(Integer userId, AddProjectReq req) {
        BaseProject p = new BaseProject();

        BeanUtils.copyProperties(req,p);
        p.setCreateBy(userId);
        p.setCreateTime(LocalDateTime.now());
        p.setUpdateBy(userId);
        p.setUpdateTime(LocalDateTime.now());

        logger.info("构建新增基础项对象完成"+p);
        return baseProjectMapper.insert(p) > 0;
    }

    @Override
    public boolean deleteProject(Integer userId, Integer id) {
        return baseProjectMapper.deleteProject(userId,id);
    }

    @Override
    public boolean updateProject(Integer userId, UpdateProjectReq req) {
        BaseProject p = new BaseProject();
        BeanUtils.copyProperties(req,p);

        p.setUpdateBy(userId);
        p.setUpdateTime(LocalDateTime.now());

        return baseProjectMapper.updateById(p) > 0;
    }

    @Override
    public List<SpotCheckProjectVO> getProjectsByCheckOrderId(Integer id) {

        return baseProjectMapper.getByCheckOrderId(id);
    }

    @Override
    public List<SpotCheckProjectVO> getProjectsDetailByCheckOrderId(Integer id) {

        List<SpotCheckProjectVO> detailByCheckOrderId = baseProjectMapper.getDetailByCheckOrderId(id);
        return detailByCheckOrderId;
    }
}
