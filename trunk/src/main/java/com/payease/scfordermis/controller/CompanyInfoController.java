package com.payease.scfordermis.controller;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqComInfoBean;
import com.payease.scfordermis.bo.responseBo.RespComInfoBean;
import com.payease.scfordermis.service.CompanyInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
@RequestMapping("/companyinfo")
@Api(tags = {"首页-设置-公司信息页面-周世杰"})
public class CompanyInfoController {
    private static final Logger log = LoggerFactory.getLogger(CompanyInfoController.class);
    @Autowired
    CompanyInfoService companyInfoService;

    @GetMapping(value = "companyinfo")
    @ApiOperation(value = "获取公司信息详情类",response = RespComInfoBean.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fCompanyId",value = "公司id",paramType = "query"),
    })
    public ResultBo companyinfo(HttpSession session,Long fCompanyId) throws Exception{
        return companyInfoService.getComInfo(session,fCompanyId);
//        ResultBo result = ResultBo.build();
//
//        RespComInfoBean resp=new RespComInfoBean();
//        resp.setfName("东盟水果商会");
//        resp.setfCategory("水果生鲜");
//        resp.setfLogo("东盟水果商会logo");
//        resp.setfContact("苏先生");
//        resp.setfMobile("18502010210");
//        resp.setfMobile("138888888888");
//        resp.setfEmail("xinmaotai@qq.com");
//        resp.setfAddress("凭祥市浦寨万鑫国际红木城2号楼三楼3-5、3-6、3-7号铺面");
//        resp.setfPostalCode("300450");
//        resp.setfPhone("122345678912");
//        resp.setfFax("1111-1111-11");
//        resp.setfWebsite("www.baidu.com");
//        resp.setfServiceNumber("4008000000");
//
//        result.setResultBody(resp);
//
//        return result;
    }

    @GetMapping(value = "savecominfo")
    @ApiOperation(value = "更新公司信息类",response = ResultBo.class)
    public ResultBo savecominfo(HttpSession session, ReqComInfoBean req) throws Exception{
        return companyInfoService.saveComInfo(session,req);
//        ResultBo result = ResultBo.build();
//        return result;
    }

}
