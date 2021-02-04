package com.focustar.qualityspotcheck.pojo.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: yangxiansheng
 * @Since: 2021/2/4
 * description: 生成抽检列表请求对象
 */
@Data
public class GenerateSpotCheckListReq {

    @NotNull(message = "抽检模板不可为空")
    private Integer tempId;

    @NotNull(message = "确认生成的抽检工单列表不可为空")
    private List<Integer> spotIds;

}
