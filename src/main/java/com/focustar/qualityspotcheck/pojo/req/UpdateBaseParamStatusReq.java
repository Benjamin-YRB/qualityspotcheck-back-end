package com.focustar.qualityspotcheck.pojo.req;

import javax.validation.constraints.NotNull;

/**
 * @Author: yangxiansheng
 * @Since: 2021/1/18
 * description:
 */
public class UpdateBaseParamStatusReq {
    @NotNull(message = "id不可为空")
    private Integer id;

    @NotNull(message = "修改的状态不可为空")
    private boolean status;

    @Override
    public String toString() {
        return "UpdateBaseParamStatusReq{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
