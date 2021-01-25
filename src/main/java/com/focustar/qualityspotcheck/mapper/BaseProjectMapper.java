package com.focustar.qualityspotcheck.mapper;

import com.focustar.qualityspotcheck.pojo.vo.BaseProjectVO;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/19
 * description:
 */
public interface BaseProjectMapper {
    List<BaseProjectVO> getAllBaseProjects();
}
