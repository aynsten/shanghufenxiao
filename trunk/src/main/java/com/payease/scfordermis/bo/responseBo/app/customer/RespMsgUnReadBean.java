package com.payease.scfordermis.bo.responseBo.app.customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 下午5:20
 **/
@ApiModel(value = "未读消息个数实体类",description = "描述未读消息实体类")
public class RespMsgUnReadBean {
    @ApiModelProperty(value = "未读消息个数",dataType = "int",required = true)
    private Integer UnReadMsgNum;
    @ApiModelProperty(value =  "消息类型:目前仅有 order:订单类型",dataType = "String",required = true)
    private String fMsgType;

    public Integer getUnReadMsgNum() {
        return UnReadMsgNum;
    }

    public void setUnReadMsgNum(Integer unReadMsgNum) {
        UnReadMsgNum = unReadMsgNum;
    }

    public String getfMsgType() {
        return fMsgType;
    }

    public void setfMsgType(String fMsgType) {
        this.fMsgType = fMsgType;
    }
}
