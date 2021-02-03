package com.focustar.qualityspotcheck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.focustar.qualityspotcheck.pojo.dto.TempOperatorDTO;
import com.focustar.qualityspotcheck.pojo.dto.TemplateDTO;
import com.focustar.qualityspotcheck.pojo.entity.QualityTemplate;
import com.focustar.qualityspotcheck.pojo.entity.TempProject;
import com.focustar.qualityspotcheck.pojo.entity.TempUser;
import com.focustar.qualityspotcheck.pojo.req.MatchOrderReq;
import com.focustar.qualityspotcheck.pojo.vo.CheckPersonNamesVO;
import com.focustar.qualityspotcheck.pojo.vo.TemplateVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/28
 * description:
 */
@Component
public interface QualityTemplateMapper extends BaseMapper<QualityTemplate> {
    List<CheckPersonNamesVO> getCheckNames(LocalDate start, LocalDate end);

    Integer matchOrder(MatchOrderReq req);

    Integer addTemplate(QualityTemplate qualityTemplate);

    int addTempUserBatch(List<TempUser> users);

    int addTempProjectBatch(List<TempProject> projects);

    List<TemplateVO> getAllTemplates();

    List<TemplateVO> getTemplatesCreateByCurrentUser(Integer userId);

    boolean deleteTemplate(@Param("id") Integer id,@Param("userId") Integer userId);

    /**
     * 根据模板id获取抽检人员的详细信息
     * @param id
     * @return
     */
    List<TempOperatorDTO> getTempOperator(Integer id);
}
