package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author : zhangwen
 * @Data : 2018/1/10
 * @Description :
 */
@ApiModel(value = "订单收款统计请求类",description = "描述订单收款统计请求参数")
public class ReqOrderMoneyBean extends PageBean{

    @ApiModelProperty(value = "付款状态 （all:全部;unTotal:未全部付清;total：已付清）",dataType = "string",required = true)
    private String payStatus;
    @ApiModelProperty(value = "开始时间",dataType = "string",required = true)
    private String startTime;
    @ApiModelProperty(value = "结束时间",dataType = "string",required = true)
    private String endTime;
    @ApiModelProperty(value = "订单号/客户名称",dataType = "string")
    private String searchKey;

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
