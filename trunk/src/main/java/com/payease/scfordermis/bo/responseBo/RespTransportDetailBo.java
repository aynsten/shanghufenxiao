package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by YHF on 2018/1/11.
 */
@ApiModel(value = "运单详情实体类",description = "运单详情实体类")
public class RespTransportDetailBo {
    @ApiModelProperty(value = "运单状态[ForLoading-待装车；ForGoods-待提货； HasCompleted-已完成]")
    private String transportStatus;
    @ApiModelProperty(value = "运单编号")
    private String transportCode;
    @ApiModelProperty(value = "销售地区")
    private String sendArea;
    @ApiModelProperty(value = "通关单号")
    private String customsFormNum;
    @ApiModelProperty(value = "制单员")
    private String operate;
    @ApiModelProperty(value = "制单时间")
    private String createTime;
    //===============================================
    @ApiModelProperty(value = "运单商品信息")
    List<RespTransportDetailGoodsBo> respTransportDetailGoodsBos;
    //    =========运输信息========
    @ApiModelProperty(value = "车牌号")
    private String fCarNum;//车牌号
    @ApiModelProperty(value = "司机")
    private String fDriverName; //司机
    @ApiModelProperty(value = "电话")
    private String fDriverPhone; //电话
    //==========备注说明===============
    @ApiModelProperty(value = "备注说明")
    private List<RespRemarkBo> remarkContent;//备注说明
    //===========操作日志======================
    @ApiModelProperty(value = "日志")
    List<RespOperationLogBo> noteBos ;

    public String getTransportStatus() {
        return transportStatus;
    }

    public void setTransportStatus(String transportStatus) {
        this.transportStatus = transportStatus;
    }

    public String getTransportCode() {
        return transportCode;
    }

    public void setTransportCode(String transportCode) {
        this.transportCode = transportCode;
    }

    public String getSendArea() {
        return sendArea;
    }

    public void setSendArea(String sendArea) {
        this.sendArea = sendArea;
    }

    public String getCustomsFormNum() {
        return customsFormNum;
    }

    public void setCustomsFormNum(String customsFormNum) {
        this.customsFormNum = customsFormNum;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<RespTransportDetailGoodsBo> getRespTransportDetailGoodsBos() {
        return respTransportDetailGoodsBos;
    }

    public void setRespTransportDetailGoodsBos(List<RespTransportDetailGoodsBo> respTransportDetailGoodsBos) {
        this.respTransportDetailGoodsBos = respTransportDetailGoodsBos;
    }

    public String getfCarNum() {
        return fCarNum;
    }

    public void setfCarNum(String fCarNum) {
        this.fCarNum = fCarNum;
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

    public List<RespRemarkBo> getRemarkContent() {
        return remarkContent;
    }

    public void setRemarkContent(List<RespRemarkBo> remarkContent) {
        this.remarkContent = remarkContent;
    }

    public List<RespOperationLogBo> getNoteBos() {
        return noteBos;
    }

    public void setNoteBos(List<RespOperationLogBo> noteBos) {
        this.noteBos = noteBos;
    }
}
