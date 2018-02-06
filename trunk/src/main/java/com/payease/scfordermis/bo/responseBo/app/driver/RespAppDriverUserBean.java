package com.payease.scfordermis.bo.responseBo.app.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhangzhili on 2018/1/11.
 */
@ApiModel("司机app我的页面实体类")
public class RespAppDriverUserBean {

    @ApiModelProperty(value = "司机名字",dataType = "string")
    private String driverName;
    @ApiModelProperty(value = "司机手机号",dataType = "string")
    private String driverPhone;
    @ApiModelProperty(value = "商家电话",dataType = "string")
    private String merchantPhone;



    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }
}

