package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhoushijie on 2018/1/11.
 * 入参
 */
@ApiModel(value = "后台登录实体类",description = "后台登录实体类")
public class ReqLoginPCBean {
    @ApiModelProperty(value = "登录账号/手机号",dataType = "string",required = true)
    private String fAccount;
    @ApiModelProperty(value = "登录密码",dataType = "string",required = true)
    private String fPassword;

    public String getfAccount() {
        return fAccount;
    }

    public void setfAccount(String fAccount) {
        this.fAccount = fAccount;
    }

    public String getfPassword() {
        return fPassword;
    }

    public void setfPassword(String fPassword) {
        this.fPassword = fPassword;
    }


}
