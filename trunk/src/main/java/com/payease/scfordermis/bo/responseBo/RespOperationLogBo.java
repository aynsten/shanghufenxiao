package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lch on 2018/1/11.
 */
@ApiModel(value = "操作日志",description = "订单/运单详情中的操作日志")
public class RespOperationLogBo {

    @ApiModelProperty(value = "公司名",dataType = "string")
    private String companyName;
    @ApiModelProperty(value = "操作人",dataType = "string")
    private String fOperator;
    @ApiModelProperty(value = "时间(格式为：yyyy-MM-dd hh:mm)",dataType = "string")
    private String fCreatetime;
    @ApiModelProperty(value = "操作类别(createOrder-创建订单;updateOrder-修改订单;cancellationOrder-订单作废;reviewOrder-订单审核;deliveryCompletion-提货完成)" +
            "'createTranOrder-创建运单;updateTranOrder-修改运单;updateTranInfo-修改运输信息;loadingConfirmation-装车确认;tranComplete-运输完成；",dataType = "string")
    private String fOperatingType;
    @ApiModelProperty(value = "操作日志",dataType = "string")
    private String fNote;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getfOperator() {
        return fOperator;
    }

    public void setfOperator(String fOperator) {
        this.fOperator = fOperator;
    }

    public String getfCreatetime() {
        return fCreatetime;
    }

    public void setfCreatetime(String fCreatetime) {
        this.fCreatetime = fCreatetime;
    }

    public String getfOperatingType() {
        return fOperatingType;
    }

    public void setfOperatingType(String fOperatingType) {
        this.fOperatingType = fOperatingType;
    }

    public String getfNote() {
        return fNote;
    }

    public void setfNote(String fNote) {
        this.fNote = fNote;
    }
}
