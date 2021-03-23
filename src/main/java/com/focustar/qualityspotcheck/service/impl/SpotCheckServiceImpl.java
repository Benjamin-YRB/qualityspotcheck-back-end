package com.focustar.qualityspotcheck.service.impl;

import com.focustar.qualityspotcheck.mapper.SpotCheckListMapper;
import com.focustar.qualityspotcheck.mapper.SpotCheckMapper;
import com.focustar.qualityspotcheck.pojo.req.SpotCheckRemarkReq;
import com.focustar.qualityspotcheck.pojo.vo.LoginVO;
import com.focustar.qualityspotcheck.pojo.vo.RoleVO;
import com.focustar.qualityspotcheck.pojo.vo.SpotCheckExVO;
import com.focustar.qualityspotcheck.pojo.vo.SpotCheckListVO;
import com.focustar.qualityspotcheck.service.SpotCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/4
 * description: 抽检相关业务逻辑
 */
@Service
public class SpotCheckServiceImpl implements SpotCheckService {

    public static final Logger logger = LoggerFactory.getLogger(SpotCheckServiceImpl.class);

    @Autowired
    SpotCheckListMapper spotCheckListMapper;

    @Autowired
    SpotCheckMapper spotCheckMapper;

    @Override
    public List<SpotCheckListVO> getSpotCheckListVOs(LoginVO loginVO) {
        boolean isSupervisor = false;//是否主管级别以上角色标记位

        for (RoleVO role : loginVO.getRoles()) {//遍历判断角色权限
            if (role.getPriority() <= 2){
                logger.info("主管级别以上获取所有抽检列表");
                isSupervisor = true;
                break;
            }
        }

        if (isSupervisor){
            return spotCheckListMapper.getAllSpotCheckListVO();
        }else{
            return spotCheckListMapper.getSpotCheckListVOsByCreatorId(loginVO.getUser().getId());
        }
    }

    @Override
    public List<SpotCheckExVO> getByListId(Integer id) {

        return spotCheckMapper.getByListId(id);
    }

    @Override
    public int updateRemark(SpotCheckRemarkReq req) {

        return spotCheckMapper.updateRemarks(req);
    }

}
