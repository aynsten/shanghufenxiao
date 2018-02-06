package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by YHF on 2018/1/11.
 */
@ApiModel(value = "运单添加请求参数类",description = "运单添加请求参数类")
public class ReqTransportAddBo {
    @ApiModelProperty(value = "运单id(运单修改的时候需要传值)")
    private String transportOrderId;
    @ApiModelProperty(value = "运单号(运单修改的时候需要传值)")
    private String transportOrderNum;
    @ApiModelProperty(value = "销售地区id(一级)",required = true)
   private String fAreaOne; //销售地区
    @ApiModelProperty(value = "销售地区id(二级)",required = true)
    private String fAreaTwo; //销售地区
    @ApiModelProperty(value = "商品id   规格id   计划装车数,此处为一个list")
    private List<ReqGoodsBo> reqGoodsBos;  //商品id   规格id   计划装车数
    @ApiModelProperty(value = "车牌号")
    private String fTransportNum;//车牌号
    @ApiModelProperty(value = "司机")
    private String fDriverName;//司机
    @ApiModelProperty(value = "司机手机号")
    private String fDriverPhone;//司机手机号
    @ApiModelProperty(value = "通关单号")
    private String fCustomsFormNo;//通关单号
    @ApiModelProperty(value = "备注")
    private String remark;

    public String getTransportOrderId() {
        return transportOrderId;
    }

    public String getTransportOrderNum() {
        return transportOrderNum;
    }

    public void setTransportOrderNum(String transportOrderNum) {
        this.transportOrderNum = transportOrderNum;
    }

    public void setTransportOrderId(String transportOrderId) {
        this.transportOrderId = transportOrderId;
    }

    public String getfAreaOne() {
        return fAreaOne;
    }

    public void setfAreaOne(String fAreaOne) {
        this.fAreaOne = fAreaOne;
    }

    public String getfAreaTwo() {
        return fAreaTwo;
    }

    public void setfAreaTwo(String fAreaTwo) {
        this.fAreaTwo = fAreaTwo;
    }

    public List<ReqGoodsBo> getReqGoodsBos() {
        return reqGoodsBos;
    }

    public void setReqGoodsBos(List<ReqGoodsBo> reqGoodsBos) {
        this.reqGoodsBos = reqGoodsBos;
    }

    public String getfTransportNum() {
        return fTransportNum;
    }

    public void setfTransportNum(String fTransportNum) {
        this.fTransportNum = fTransportNum;
    }

    public String getfDriverName() {
        return fDriverName;
    }

    public void setfDriverName(String fDriverName) {
        this.fDriverName = fDriverName;
    }

    public String getfDriverPhone() {
        return fDriverPhone;
    }

    public void setfDriverPhone(String fDriverPhone) {
        this.fDriverPhone = fDriverPhone;
    }

    public String getfCustomsFormNo() {
        return fCustomsFormNo;
    }

    public void setfCustomsFormNo(String fCustomsFormNo) {
        this.fCustomsFormNo = fCustomsFormNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
