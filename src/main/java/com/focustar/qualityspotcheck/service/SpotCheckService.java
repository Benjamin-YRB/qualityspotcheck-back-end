package com.focustar.qualityspotcheck.service;

import com.focustar.qualityspotcheck.pojo.req.SpotCheckRemarkReq;
import com.focustar.qualityspotcheck.pojo.vo.LoginVO;
import com.focustar.qualityspotcheck.pojo.vo.SpotCheckExVO;
import com.focustar.qualityspotcheck.pojo.vo.SpotCheckListVO;

import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/4
 * description:
 */
public interface SpotCheckService {
    List<SpotCheckListVO> getSpotCheckListVOs(LoginVO loginVO);

    List<SpotCheckExVO> getByListId(Integer id);

    int updateRemark(SpotCheckRemarkReq req);

}
