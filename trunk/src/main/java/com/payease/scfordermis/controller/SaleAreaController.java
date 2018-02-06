package com.payease.scfordermis.controller;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqSaveSellAreaBean;
import com.payease.scfordermis.bo.responseBo.RespAreaListBean;
import com.payease.scfordermis.service.SaleAreaService;
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
 * Created by zhoushijie on 2018/1/11.
 */
@RestController
@RequestMapping("/sellarea")
@Api(tags = {"首页-客户-销售区域-周世杰"})
public class SaleAreaController {
    private static final Logger log = LoggerFactory.getLogger(SaleAreaController.class);
        @Autowired
        private SaleAreaService saleAreaService;

    @GetMapping(value = "arealist")
    @ApiOperation(value = "销售地区列表",response = RespAreaListBean.class)
    public ResultBo arealist(HttpSession session) throws Exception{
            return saleAreaService.arealist(session);
//        ResultBo result = ResultBo.build();
//
//
//        List<RespAreaListBean> FUlist = new ArrayList<>();
//        List<RespAreaListBean> ZIlist1 = new ArrayList<>();
//        List<RespAreaListBean> ZIlist2 = new ArrayList<>();
//
//        RespAreaListBean FUentity1 = new RespAreaListBean();
//        FUentity1.setfId(Long.valueOf(1));
//        FUentity1.setfParentId(null);
//        FUentity1.setfName("华北区域");
//
//        RespAreaListBean FUentity2 = new RespAreaListBean();
//        FUentity2.setfId(Long.valueOf(2));
//        FUentity2.setfParentId(null);
//        FUentity2.setfName("通用区域");
//
//        RespAreaListBean ZIentity1 = new RespAreaListBean();
//        ZIentity1.setfId(Long.valueOf(3));
//        ZIentity1.setfParentId(Long.valueOf(1));
//        ZIentity1.setfName("北京");
//
//        RespAreaListBean ZIentity2 = new RespAreaListBean();
//        ZIentity2.setfId(Long.valueOf(4));
//        ZIentity2.setfParentId(Long.valueOf(1));
//        ZIentity2.setfName("天津");
//
//        ZIlist1.add(ZIentity1);
//        ZIlist1.add(ZIentity2);
//
//        RespAreaListBean ZIentity3 = new RespAreaListBean();
//        ZIentity3.setfId(Long.valueOf(5));
//        ZIentity3.setfParentId(Long.valueOf(2));
//        ZIentity3.setfName("通用一区");
//
//        RespAreaListBean ZIentity4 = new RespAreaListBean();
//        ZIentity4.setfId(Long.valueOf(6));
//        ZIentity4.setfParentId(Long.valueOf(2));
//        ZIentity4.setfName("通用二区");
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

    @PutMapping(value = "savesell")
    @ApiOperation(value = "新增修改区域",response = ResultBo.class)
    public ResultBo save(HttpSession session,ReqSaveSellAreaBean reqSaveSellAreaBean) throws Exception{
        return saleAreaService.save(session, reqSaveSellAreaBean);
//        ResultBo result = ResultBo.build();
//        return result;
    }

    @DeleteMapping(value = "delete")
    @ApiOperation(value = "删除",response = ResultBo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "areaId",value = "区域ID",paramType = "query",required = true),
    })
    public ResultBo delete(HttpSession session, Long areaId) throws Exception{
        return saleAreaService.delete(session, areaId);
//        ResultBo result = ResultBo.build();
//        return result;
    }
}
