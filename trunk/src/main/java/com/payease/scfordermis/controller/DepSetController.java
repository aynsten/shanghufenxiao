package com.payease.scfordermis.controller;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqSaveDepSetBean;
import com.payease.scfordermis.bo.responseBo.RespDepSetListBean;
import com.payease.scfordermis.service.DepSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 上午10:24
 **/
@RestController
@RequestMapping("/depset")
@Api(tags = {"首页-设置-部门设置-刘晓明"})
public class DepSetController {
    private static final Logger log = LoggerFactory.getLogger(DepSetController.class);

    @Autowired
    private DepSetService depSetService;

    @GetMapping(value = "deplist")
    @ApiOperation(value = "部门列表",response = RespDepSetListBean.class)
    public ResultBo deplist(HttpSession session) throws Exception{
        return depSetService.deplist(session);
//        ResultBo result = ResultBo.build();
//
//
//        List<RespDepSetListBean> FUlist = new ArrayList<>();
//        List<RespDepSetListBean> ZIlist1 = new ArrayList<>();
//        List<RespDepSetListBean> ZIlist2 = new ArrayList<>();
//
//        RespDepSetListBean FUentity1 = new RespDepSetListBean();
//        FUentity1.setfId(Long.valueOf(1));
//        FUentity1.setfParentId(Long.valueOf(0));
//        FUentity1.setfName("总公司");
//
//        RespDepSetListBean FUentity2 = new RespDepSetListBean();
//        FUentity2.setfId(Long.valueOf(2));
//        FUentity2.setfParentId(Long.valueOf(0));
//        FUentity2.setfName("华北分部");
//
//        RespDepSetListBean ZIentity1 = new RespDepSetListBean();
//        ZIentity1.setfId(Long.valueOf(3));
//        ZIentity1.setfParentId(Long.valueOf(1));
//        ZIentity1.setfName("业务部");
//
//        RespDepSetListBean ZIentity2 = new RespDepSetListBean();
//        ZIentity2.setfId(Long.valueOf(4));
//        ZIentity2.setfParentId(Long.valueOf(1));
//        ZIentity2.setfName("财务部");
//
//        ZIlist1.add(ZIentity1);
//        ZIlist1.add(ZIentity2);
//
//        RespDepSetListBean ZIentity3 = new RespDepSetListBean();
//        ZIentity3.setfId(Long.valueOf(5));
//        ZIentity3.setfParentId(Long.valueOf(2));
//        ZIentity3.setfName("华北业务部");
//
//        RespDepSetListBean ZIentity4 = new RespDepSetListBean();
//        ZIentity4.setfId(Long.valueOf(6));
//        ZIentity4.setfParentId(Long.valueOf(2));
//        ZIentity4.setfName("华北财务部");
//
//        ZIlist2.add(ZIentity3);
//        ZIlist2.add(ZIentity4);
//
//
//        FUentity1.setChildList(ZIlist1);
//        FUentity2.setChildList(ZIlist2);
//
//        FUlist.add(FUentity1);
//        FUlist.add(FUentity2);
//
//
//        result.setResultBody(FUlist);
//
//        return result;
    }


    @PutMapping(value = "save")
    @ApiOperation(value = "新增修改部门",response = ResultBo.class)
    public ResultBo save(HttpSession session,ReqSaveDepSetBean reqSaveDepSetBean) throws Exception{
        return depSetService.save(session,reqSaveDepSetBean);
//        ResultBo result = ResultBo.build();
//        return result;
    }



    @DeleteMapping(value = "delete")
    @ApiOperation(value = "删除",response = ResultBo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "depId",value = "部门ID",paramType = "query",required = true),
    })
    public ResultBo delete(HttpSession session, Long depId) throws Exception{
        return depSetService.delete(session,depId);
//        ResultBo result = ResultBo.build();
//        return result;
    }


}
