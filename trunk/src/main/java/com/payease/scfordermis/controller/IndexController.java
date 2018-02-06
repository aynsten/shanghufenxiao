package com.payease.scfordermis.controller;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.responseBo.RespIndexListBean;
import com.payease.scfordermis.service.IIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : zhangwen
 * @Data : 2018/1/10
 * @Description :
 */
@RestController
@RequestMapping("/index")
@Api(tags = {"首页数据类-zhangwen"})
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);


    @Autowired
    private IIndexService indexService;

    @GetMapping(value = "index")
    @ApiOperation(value = "获取首页展示数据",response = RespIndexListBean.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryType",value = "时间类型（thisMonth:本月，lastMonth:上月）",paramType = "query",required = true)
    })
    public ResultBo index(HttpSession session,String queryType) {
        ResultBo result = ResultBo.build();
        try {
            RespIndexListBean bean = new RespIndexListBean();
//            bean.setOrderMoney("1000");
//            bean.setOrderConsumerNumber(100);
//            bean.setOrderTotalNumber(10000);
//            List<String[]> linear= new ArrayList<String[]>();
//            for (int i = 0;i<=5;i++){
//                String[] param = {"2018-01-0"+i,"100"+i};
//                linear.add(param);
//            }
//            bean.setLinear(linear);
            //TODO 暂时使用挡板 下面的代码是正确的 测试时直接解开 该接口已调通
            if(StringUtils.isBlank(queryType)||(!queryType.equals("thisMonth")&&!queryType.equals("lastMonth"))){
                return result.queryError();
            }
            bean = indexService.index(session,queryType);
            result.setResultBody(bean);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("index",e);
            result.fail();
        }finally {
            return result;
        }

    }



}
