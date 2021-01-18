package com.focustar.qualityspotcheck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.focustar.qualityspotcheck.pojo.entity.BaseParam;
import com.focustar.qualityspotcheck.pojo.vo.BaseParamVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/17
 * description:
 */
@Component
public interface BaseParamMapper extends BaseMapper<BaseParam> {
    List<BaseParamVO> getAllBaseParamVO();
}
