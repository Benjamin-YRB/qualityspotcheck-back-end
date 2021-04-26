package com.focustar.qualityspotcheck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.focustar.qualityspotcheck.pojo.entity.SpotCheck;
import com.focustar.qualityspotcheck.pojo.entity.SpotCheckProjectScore;
import com.focustar.qualityspotcheck.pojo.req.SpotCheckRemarkReq;
import com.focustar.qualityspotcheck.pojo.req.SubmitSpotCheckReq;
import com.focustar.qualityspotcheck.pojo.vo.SpotCheckExVO;
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

    List<SpotCheck> getByIds(List<Integer> ids);

    /**
     * 根据列表id获取抽检时抽检工单视图对象
     * @param id
     * @return
     */
    List<SpotCheckExVO> getByListId(Integer id);

    int updateRemarks(SpotCheckRemarkReq req);

    void batchInsertCheckProjectScore(List<SpotCheckProjectScore> list);

    Integer getPassScoreBySpotCheckId(Integer id);

    Integer submitSpotCheck(SubmitSpotCheckReq req);

    Integer updateStatusToCheckComplete(Integer id);
}
