package com.focustar.qualityspotcheck.service.impl;

import com.focustar.qualityspotcheck.mapper.BaseProjectMapper;
import com.focustar.qualityspotcheck.pojo.vo.BaseProjectVO;
import com.focustar.qualityspotcheck.service.BaseProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/19
 * description:
 */
@Service
public class BaseProjectServiceImpl implements BaseProjectService {

    @Autowired
    BaseProjectMapper baseProjectMapper;

    @Override
    public List<BaseProjectVO> getAllBaseProjects() {

        return baseProjectMapper.getAllBaseProjects();
    }
}
