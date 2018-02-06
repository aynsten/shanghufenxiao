package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 下午2:23
 **/
@ApiModel(value = "员工列表查询实体",description = "描述员工列表查询类")
public class RespEmpAccNumBean {
    @ApiModelProperty(value = "序号",dataType = "long",required = true)
    private long fId;
    @ApiModelProperty(value = "部门",dataType = "string",required = true)
    private String fDepartIdTwo;
    @ApiModelProperty(value = "账号",dataType = "string",required = true)
    private String fAccount;
    @ApiModelProperty(value = "账号状态:  open-开通 close-禁用 ",dataType = "string",required = true)
    private String fStatus;
    @ApiModelProperty(value = "姓名",dataType = "string",required = true)
    private String fName;
    @ApiModelProperty(value = "手机",dataType = "string",required = true)
    private String fMobile;
    @ApiModelProperty(value = "邮箱",dataType = "string",required = true)
    private String fEmail;
    @ApiModelProperty(value = "职位",dataType = "string",required = true)
    private String fPosition;

    public long getfId() {
        return fId;
    }

    public void setfId(long fId) {
        this.fId = fId;
    }

    public String getfDepartIdTwo() {
        return fDepartIdTwo;
    }

    public void setfDepartIdTwo(String fDepartIdTwo) {
        this.fDepartIdTwo = fDepartIdTwo;
    }

    public String getfAccount() {
        return fAccount;
    }

    public void setfAccount(String fAccount) {
        this.fAccount = fAccount;
    }


    public String getfStatus() {
        return fStatus;
    }

    public void setfStatus(String fStatus) {
        this.fStatus = fStatus;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfMobile() {
        return fMobile;
    }

    public void setfMobile(String fMobile) {
        this.fMobile = fMobile;
    }

    public String getfEmail() {
        return fEmail;
    }

    public void setfEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    public String getfPosition() {
        return fPosition;
    }

    public void setfPosition(String fPosition) {
        this.fPosition = fPosition;
    }

    @Override
    public String toString() {
        return "RespEmpAccNumBean{" +
                "fId=" + fId +
                ", fDepartIdTwo='" + fDepartIdTwo + '\'' +
                ", fAccount='" + fAccount + '\'' +
                ", fStatus='" + fStatus + '\'' +
                ", fName='" + fName + '\'' +
                ", fMobile='" + fMobile + '\'' +
                ", fEmail='" + fEmail + '\'' +
                ", fPosition='" + fPosition + '\'' +
                '}';
    }
}
