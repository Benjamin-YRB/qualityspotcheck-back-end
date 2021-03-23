package com.focustar.qualityspotcheck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.focustar.qualityspotcheck.pojo.entity.SpotCheckList;
import com.focustar.qualityspotcheck.pojo.vo.SpotCheckExVO;
import com.focustar.qualityspotcheck.pojo.vo.SpotCheckListVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/4
 * description:
 */
@Component
public interface SpotCheckListMapper extends BaseMapper<SpotCheckList> {

    List<SpotCheckListVO> getAllSpotCheckListVO();

    List<SpotCheckListVO> getSpotCheckListVOsByCreatorId(Integer id);

}
