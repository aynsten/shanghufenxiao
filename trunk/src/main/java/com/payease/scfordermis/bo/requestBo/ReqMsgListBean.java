package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 上午10:45
 **/
@ApiModel(value = "消息列表实体类",description = "描述消息列表实体类")
public class ReqMsgListBean extends PageBean{

    @ApiModelProperty(value = "消息类型 : order:订单消息",dataType = "string",required = true)
    private String fMsgType;

    public String getfMsgType() {
        return fMsgType;
    }

    public void setfMsgType(String fMsgType) {
        this.fMsgType = fMsgType;
    }
}
