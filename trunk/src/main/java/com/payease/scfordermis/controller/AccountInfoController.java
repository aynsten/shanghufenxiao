package com.payease.scfordermis.controller;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqAccountInfoBean;
import com.payease.scfordermis.bo.requestBo.ReqAccInfoResetPwdBean;
import com.payease.scfordermis.service.AccountInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by zhoushijie on 2018/1/10.
 */
@RestController
@RequestMapping("/AccountInfo")
@Api(tags = {"首页-账号信息页面-周世杰"})
public class AccountInfoController {
    private static final Logger log = LoggerFactory.getLogger(AccountInfoController.class);
    @Autowired
    AccountInfoService accountInfoService;


    //密码保存
    @GetMapping(value = "/saveresetpwd")
    @ApiOperation(value = "修改重设密码类",response = ResultBo.class)
    public ResultBo saveresetpwd(HttpSession session, ReqAccInfoResetPwdBean req) throws Exception{
       return accountInfoService.savepwd(session,req);
//        ResultBo result = ResultBo.build();
//        return result;
    }


    //修改信息
    @GetMapping(value = "/saveaccInfo")
    @ApiOperation(value = "修改用户信息类",response = ResultBo.class)
    public ResultBo saveaccInfo(HttpSession session, ReqAccountInfoBean req)throws Exception {
        return accountInfoService.saveaccinfo(session,req);
//        ResultBo result = ResultBo.build();
//        return result;
    }


}
