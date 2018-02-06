package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lch on 2018/1/10.
 * <p>
 * 集散地订单列表返回对象
 */
@ApiModel(value = "集散地订单列表返回参数", description = "集散地订单列表")
public class RespDistributionOrderBo {

    @ApiModelProperty(value = "订单id", dataType = "long")
    private Long id;
    @ApiModelProperty(value = "订单号", dataType = "string")
    private String fOrderNum;
    @ApiModelProperty(value = "是否是特价(yes-是特价,no-不是特价)", dataType = "string")
    private String fSpecial;
    @ApiModelProperty(value = "运单号", dataType = "string")
    private String fTransportNum;
    @ApiModelProperty(value = "下单时间(格式为：yyyy-MM-dd hh:mm)", dataType = "string")
    private String fCreateTime;
    @ApiModelProperty(value = "客户", dataType = "string")
    private String consumerName;
    @ApiModelProperty(value = "金额", dataType = "string")
    private String fOrderAmountPay;
    @ApiModelProperty(value = "订单状态(0-待订单审核;1-待提货;2-已完成;-1-已作废)", dataType = "int")
    private int fOrderStatus;
    @ApiModelProperty(value = "付款状态", dataType = "string")
    private String fPayStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfOrderNum() {
        return fOrderNum;
    }

    public void setfOrderNum(String fOrderNum) {
        this.fOrderNum = fOrderNum;
    }

    public String getfSpecial() {
        return fSpecial;
    }

    public void setfSpecial(String fSpecial) {
        this.fSpecial = fSpecial;
    }

    public String getfTransportNum() {
        return fTransportNum;
    }

    public void setfTransportNum(String fTransportNum) {
        this.fTransportNum = fTransportNum;
    }

    public String getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(String fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getfOrderAmountPay() {
        return fOrderAmountPay;
    }

    public void setfOrderAmountPay(String fOrderAmountPay) {
        this.fOrderAmountPay = fOrderAmountPay;
    }

    public int getfOrderStatus() {
        return fOrderStatus;
    }

    public void setfOrderStatus(int fOrderStatus) {
        this.fOrderStatus = fOrderStatus;
    }

    public String getfPayStatus() {
        return fPayStatus;
    }

    public void setfPayStatus(String fPayStatus) {
        this.fPayStatus = fPayStatus;
    }
}
