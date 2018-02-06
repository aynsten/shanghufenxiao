package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lch on 2018/1/11.
 * <p>
 * 添加/修改订单入参
 */
@ApiModel(value = "添加/修改订单入参", description = "添加/修改订单入参")
public class ReqSaveOrUpdateOrderBo {

    @ApiModelProperty(value = "订单id（修改时必填,添加时不填）", dataType = "long")
    private Long id;
    @ApiModelProperty(value = "运单id（添加时必填,修改时不填）", dataType = "long")
    private Long fTransportOrderId;
    @ApiModelProperty(value = "运单号（添加时必填,修改时不填）", dataType = "string")
    private String fTransportNum;
    @ApiModelProperty(value = "客户id（添加时必填,修改时不填）", dataType = "long")
    private Long fConsumerId;
    @ApiModelProperty(value = "订单详情json（id代表订单id--只在修改订单时有值，fTranOrderDetailId代表运单详情id，fProductNum代表商品数量）" +
            "例如：[{\"id\":\"1\",\"fTranOrderDetailId\":\"1\",\"fProductNum\":\"1000\"},{\"id\":\"2\",\"fTranOrderDetailId\":\"2\",\"fProductNum\":\"1500\"}]", dataType = "string", required = true)
    private String orderDetailJson;
    @ApiModelProperty(value = "是否是特价(yes-是特价,no-不是特价)", dataType = "string", required = true)
    private String fSpecial;
    @ApiModelProperty(value = "金额（特价时必填,不是特价时不填）", dataType = "string")
    private String fOrderAmountPay;
    @ApiModelProperty(value = "交易方式(prePayAll-预付所有;prePayPary-预付部分;notPrePay-赊销)", dataType = "string", required = true)
    private String fPayMethod;
    @ApiModelProperty(value = "预付金额(交易方式为prePayPary时有值)", dataType = "string")
    private String fPreAmount;
    @ApiModelProperty(value = "备注说明", dataType = "string")
    private String remark;
    @ApiModelProperty(value = "总数量（计算出来的）", dataType = "string", required = true)
    private int totalQuantity;
    @ApiModelProperty(value = "总金额（计算出来的）", dataType = "string", required = true)
    private String totalAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getfTransportOrderId() {
        return fTransportOrderId;
    }

    public void setfTransportOrderId(Long fTransportOrderId) {
        this.fTransportOrderId = fTransportOrderId;
    }

    public String getfTransportNum() {
        return fTransportNum;
    }

    public void setfTransportNum(String fTransportNum) {
        this.fTransportNum = fTransportNum;
    }

    public Long getfConsumerId() {
        return fConsumerId;
    }

    public void setfConsumerId(Long fConsumerId) {
        this.fConsumerId = fConsumerId;
    }

    public String getOrderDetailJson() {
        return orderDetailJson;
    }

    public void setOrderDetailJson(String orderDetailJson) {
        this.orderDetailJson = orderDetailJson;
    }

    public String getfSpecial() {
        return fSpecial;
    }

    public void setfSpecial(String fSpecial) {
        this.fSpecial = fSpecial;
    }

    public String getfOrderAmountPay() {
        return fOrderAmountPay;
    }

    public void setfOrderAmountPay(String fOrderAmountPay) {
        this.fOrderAmountPay = fOrderAmountPay;
    }

    public String getfPayMethod() {
        return fPayMethod;
    }

    public void setfPayMethod(String fPayMethod) {
        this.fPayMethod = fPayMethod;
    }

    public String getfPreAmount() {
        return fPreAmount;
    }

    public void setfPreAmount(String fPreAmount) {
        this.fPreAmount = fPreAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}