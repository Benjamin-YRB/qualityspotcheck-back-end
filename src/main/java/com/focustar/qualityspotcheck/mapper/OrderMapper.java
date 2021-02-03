package com.focustar.qualityspotcheck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.focustar.qualityspotcheck.pojo.dto.TempOperatorDTO;
import com.focustar.qualityspotcheck.pojo.entity.Order;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/2
 * description:
 */
@Component
public interface OrderMapper extends BaseMapper<Order> {
    LinkedList<Order> getAllTemplateMatchOrder(List<TempOperatorDTO> tempOperatorDTOS);
}
