package com.focustar.qualityspotcheck.service.impl;

import com.focustar.qualityspotcheck.mapper.OrderMapper;
import com.focustar.qualityspotcheck.mapper.QualityTemplateMapper;
import com.focustar.qualityspotcheck.mapper.SpotCheckMapper;
import com.focustar.qualityspotcheck.pojo.dto.TempOperatorDTO;
import com.focustar.qualityspotcheck.pojo.entity.*;
import com.focustar.qualityspotcheck.pojo.req.AddQualityTemplateReq;
import com.focustar.qualityspotcheck.pojo.req.MatchOrderReq;
import com.focustar.qualityspotcheck.pojo.vo.*;
import com.focustar.qualityspotcheck.service.QualityTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/28
 * description:
 */
@Service
public class QualityTemplateServiceImpl implements QualityTemplateService {

    public static final Logger logger = LoggerFactory.getLogger(QualityTemplateServiceImpl.class);

    @Autowired
    QualityTemplateMapper qualityTemplateMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    SpotCheckMapper spotCheckMapper;

    @Override
    public List<CheckPersonNamesVO> getCheckNames(LocalDate start, LocalDate end) {

        return qualityTemplateMapper.getCheckNames(start,end);
    }

    @Override
    public Integer matchOrder(MatchOrderReq req) {
        return qualityTemplateMapper.matchOrder(req);
    }

    @Override
    @Transactional
    public boolean addTemplate(AddQualityTemplateReq req, LoginVO loginVO) {
        QualityTemplate qualityTemplate = new QualityTemplate();

        BeanUtils.copyProperties(req,qualityTemplate);
        qualityTemplate.setCreateBy(loginVO.getUser().getId());
        qualityTemplate.setCreateTime(LocalDateTime.now());
        qualityTemplate.setLastUpdateBy(loginVO.getUser().getId());
        qualityTemplate.setLastUpdateTime(LocalDateTime.now());
        qualityTemplate.setDelFlag(false);
        qualityTemplate.setCheckPersonNum(req.getCheckPersonIds().size());

        //插入模板
        qualityTemplateMapper.insert(qualityTemplate);

        List<TempUser> users = new ArrayList<>(req.getCheckPersonIds().size());
        //批量插入模板关联到的抽检人员
        for (Integer checkPersonId : req.getCheckPersonIds()) {
            TempUser tempUser = new TempUser(qualityTemplate.getId(),checkPersonId);
            users.add(tempUser);
        }
        qualityTemplateMapper.addTempUserBatch(users);

        //批量插入模板关联的抽检项目
        List<TempProject> projects = new ArrayList<>(req.getCheckProjectIds().size());
        for (Integer checkProjectId : req.getCheckProjectIds()) {
            TempProject tempProject = new TempProject(qualityTemplate.getId(),checkProjectId);
            projects.add(tempProject);
        }
        qualityTemplateMapper.addTempProjectBatch(projects);

        return true;
    }

    @Override
    public List<TemplateVO> getAllTemplates(LoginVO loginVO) {
        boolean isSupervisor = false;
        for (RoleVO role : loginVO.getRoles()) {
            if (role.getPriority() <= 2) {
                isSupervisor = true;
            }
        }

        if (isSupervisor){
            logger.info("主管级别以上获取所有抽检模板信息");
            return qualityTemplateMapper.getAllTemplates();
        }else {
            logger.info("质检人员获取部分模板信息");
            return qualityTemplateMapper.getTemplatesCreateByCurrentUser(loginVO.getUser().getId());
        }
    }

    @Override
    public boolean deleteTemplate(Integer id,LoginVO loginVO) {

        return qualityTemplateMapper.deleteTemplate(id,loginVO.getUser().getId());
    }

    @Override
    @Transactional
    public UseTemplateResultVO useTemplate(Integer id, LoginVO loginVO) {
        UseTemplateResultVO vo = new UseTemplateResultVO();

        QualityTemplate qualityTemplate = qualityTemplateMapper.selectById(id);//查询当前使用的模板

        //获取模板匹配到的话务员详细信息
        List<TempOperatorDTO> tempOperator = qualityTemplateMapper.getTempOperator(qualityTemplate.getId());

        //根据话务员匹配到工单
        List<Order> orders = orderMapper.getAllTemplateMatchOrder(tempOperator);


        Integer selectNum = qualityTemplate.getSelectNum();//获取该模板要抽检的工单数量
        Integer checkPersonNum = qualityTemplate.getCheckPersonNum();//该模板添加时设置的抽检人员数量

        vo.setTotal(orders.size());//设置当前模板匹配的工单数量

        List<SpotCheck> spotChecks = new ArrayList<>(selectNum);//插入数据库的对象

        int n = selectNum; //记录添加进视图结果list的数量
        if (qualityTemplate.getAverage()){
            logger.info("该模板按人均分配");
            if(selectNum < checkPersonNum){//抽检数量小于话务员数量，按顺序一人一条工单
                logger.info("该模板抽检的工单数量小于话务员数量");

                for (TempOperatorDTO tempOperatorDTO : tempOperator) {
                    for (Order order : orders) {
                        if (order.getUserId().equals(tempOperatorDTO.getId())){//一个话务员匹配一条工单

                            //组建抽检工单表对象
                            SpotCheck spotCheck = orderCopyToSpotCheck(order,loginVO);

                            spotChecks.add(spotCheck);//将组建好的对象添加到预插入集合中
                            n--;
                            break;//一人一个，因此终止遍历工单表，进入下一个话务员工单的添加
                        }
                    }
                    if (n == 0){
                        //添加数量达到抽检数量，终止循环
                        break;
                    }
                }
            }else{
                logger.info("该模板抽检的工单数量大于话务员数量");
                int eachPersonNum = selectNum / checkPersonNum;//每人要抽检的工单数量
                int last = selectNum % checkPersonNum;//按每人抽检工单数量分配之后的余数
                int gap = 0;//记录工单缺口，若某一话务员工单数量无法满足规定的分配条数，则累加工单数量缺口

                //使用迭代器遍历时删除选中的工单，避免重复添加
                ListIterator<Order> orderListIterator = orders.listIterator();

                for (TempOperatorDTO tempOperatorDTO : tempOperator) {
                    int count = 0;//记录当前话务员抽检到工单的数量
                    while (orderListIterator.hasNext()){
                        Order order = orderListIterator.next();
                        if (order.getUserId().equals(tempOperatorDTO.getId())){//匹配一条
                            //组建抽检工单表对象
                            SpotCheck spotCheck = orderCopyToSpotCheck(order,loginVO);

                            spotChecks.add(spotCheck);//将组建好的对象添加到预插入集合中
                            orderListIterator.remove();//移除添加之后的抽检工单，避免后续补齐缺口的时候添加重复的抽检工单
                            n--;
                            count++;
                            if (count >= eachPersonNum){//匹配的工单数量已达要求
                                break;
                            }
                        }
                    }
                    if (count < eachPersonNum){//所有工单遍历完毕，但当前遍历到的话务员工单数量不满足要求，存在数量缺口，累加记录
                        gap += eachPersonNum - count;
                    }
                }
                int totalGap = last + gap; //总缺口
                if (totalGap > 0){//补齐缺口
                    int i = 0;
                    for (Order order : orders) {
                        SpotCheck spotCheck = orderCopyToSpotCheck(order, loginVO);

                        spotChecks.add(spotCheck);
                        i++;
                        if (i >= totalGap) break;
                    }
                }
            }
        }else{
            logger.info("该模板随机分配");
            int j = orders.size() / selectNum;

            //分段随机抽取抽检工单
            int randNum = new Random().nextInt();//产生一个段落内的随机数
            for (Integer i = 0; i < selectNum; i++) {
                Order order = orders.get(randNum + (i * j));
                //组建抽检工单表对象
                SpotCheck spotCheck = orderCopyToSpotCheck(order,loginVO);

                spotChecks.add(spotCheck);
            }
        }

        spotCheckMapper.addSpotCheckBatch(spotChecks);//批量插入抽检工单并接收返回的id

        List<SpotCheckVO> spotCheckVOS = new ArrayList<>(selectNum);//返回视图的对象

        for (SpotCheck spotCheck : spotChecks) {
            SpotCheckVO spotCheckVO = new SpotCheckVO();

            BeanUtils.copyProperties(spotCheck,spotCheckVO);
            spotCheckVOS.add(spotCheckVO);//添加到视图对象集合
        }
        vo.setNum(selectNum);//设置当前匹配成功的工单数量
        vo.setCheckVOS(spotCheckVOS);

        return vo;
    }

    /**
     * 抽取复制属性
     * @param order
     */
    private SpotCheck orderCopyToSpotCheck(Order order,LoginVO loginVO) {
        SpotCheck spotCheck = new SpotCheck();

        spotCheck.setOrderId(order.getId());
        spotCheck.setAgentId(order.getUserId());
        spotCheck.setCallingNo(order.getCallingNo());
        spotCheck.setQualityStatus(0);
        spotCheck.setRingTime(order.getRingTime());
        spotCheck.setAcceptTime(order.getAcceptTime());
        spotCheck.setEndTime(order.getEndTime());
        spotCheck.setRecordPath(order.getRecordPath());
        spotCheck.setComeFrom(order.getComeFrom());
        spotCheck.setAgentName(order.getUserName());
        spotCheck.setCreateBy(loginVO.getUser().getId());
        spotCheck.setCreateTime(LocalDateTime.now());
        spotCheck.setUpdateBy(loginVO.getUser().getId());
        spotCheck.setUpdateTime(LocalDateTime.now());
        spotCheck.setDelFlag(false);

        return spotCheck;
    }
}
