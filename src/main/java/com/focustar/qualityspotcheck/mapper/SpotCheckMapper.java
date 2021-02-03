package com.focustar.qualityspotcheck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.focustar.qualityspotcheck.pojo.entity.SpotCheck;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/3
 * description:
 */
@Component
public interface SpotCheckMapper extends BaseMapper<SpotCheck> {

    void addSpotCheckBatch(List<SpotCheck> spotChecks);

}
