package com.payease.scfordermis.controller;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqEmpAccNumBean;
import com.payease.scfordermis.bo.requestBo.ReqEmpSaveBean;
import com.payease.scfordermis.bo.responseBo.PageResponseCommBean;
import com.payease.scfordermis.bo.responseBo.RespEmpDetailBean;
import com.payease.scfordermis.bo.responseBo.RespEmpRoleInfoBean;
import com.payease.scfordermis.service.EmpAccNumService;
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
@RequestMapping("/empaccnum")
@Api(tags = {"首页-设置-员工账号-刘晓明"})
public class EmpAccNumController {
    private static final Logger log = LoggerFactory.getLogger(EmpAccNumController.class);

    @Autowired
    private EmpAccNumService empAccNumService;

    @GetMapping(value = "emplist")
    @ApiOperation(value = "员工列表查询",response = PageResponseCommBean.class)
    public ResultBo emplist(HttpSession session, ReqEmpAccNumBean reqEmpAccNumBean) throws Exception{
       return empAccNumService.getEmpAccNumList(session,reqEmpAccNumBean);

//        ResultBo result = ResultBo.build();
//
//
//        PageResponseCommBean bean = new PageResponseCommBean();
//        List<RespEmpAccNumBean> list = new ArrayList<>();
//        RespEmpAccNumBean resp = new RespEmpAccNumBean();
//        resp.setfId(1);
//        resp.setfAccount("zhangsanacc");
//        resp.setfName("zhangsan");
//        resp.setfPosition("业务经理");
//        resp.setfDepartIdTwo("业务部");
//        resp.setfMobile("18920736652");
//        resp.setfEmail("404812357@qq.com");
//        resp.setfStatus("open");
//        list.add(resp);
//
//        bean.setContent(list);
//        bean.setNumber(1);
//        bean.setSize(5);
//        bean.setTotalElements(1);
//        bean.setTotalPages(1);
//        result.setResultBody(bean);
//
//        return result;
    }


    @GetMapping(value = "empdetail")
    @ApiOperation(value = "员工详情",response = RespEmpDetailBean.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeInfoId",value = "员工ID",paramType = "query",required = true),
    })
    public ResultBo empdetail(HttpSession session, Long employeeInfoId) throws Exception{
        return empAccNumService.empDetail(employeeInfoId);
//        ResultBo result = ResultBo.build();
//
//        RespEmpDetailBean resp = new RespEmpDetailBean();
//        resp.setfId(employeeInfoId);
//        resp.setfAccount("zhangsanacc");
//        resp.setfName("zhangsan");
//        resp.setfPosition("业务经理");
//        resp.setfDepartIdTwo("业务部");
//        resp.setfMobile("18920736652");
//        resp.setfEmail("404812357@qq.com");
//        resp.setfStatus("open");
//        resp.setfQq("404812357");
//        result.setResultBody(resp);
//
//        return result;
    }



    @PutMapping(value = "save")
    @ApiOperation(value = "添加修改",response = ResultBo.class)
    public ResultBo save(HttpSession session, ReqEmpSaveBean reqEmpSave) throws Exception{
//        ResultBo result = ResultBo.build();
//        return result;
        return empAccNumService.save(session,reqEmpSave);
    }



    @DeleteMapping(value = "delete")
    @ApiOperation(value = "删除",response = ResultBo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeInfoId",value = "员工ID",paramType = "query",required = true),
    })
    public ResultBo delete(HttpSession session, Long employeeInfoId) throws Exception{
        return empAccNumService.deleteEmpAccNumById(session,employeeInfoId);
//        ResultBo result = ResultBo.build();
//        return result;
    }

    @PostMapping(value = "resetpwd")
    @ApiOperation(value = "重置密码",response = ResultBo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeInfoId",value = "员工ID",paramType = "query",required = true),
            @ApiImplicitParam(name = "fPassword",value = "密码",paramType = "query",required = true)
    })
    public ResultBo resetpwd(HttpSession session, Long employeeInfoId, String fPassword) throws Exception{
        return empAccNumService.resetPwd(session, employeeInfoId, fPassword);
//        ResultBo result = ResultBo.build();
//        return result;
    }

    //权限设置列表（对应页面中的权限列表）
    @GetMapping(value = "authlist")
    @ApiOperation(value = "角色列表",response = RespEmpRoleInfoBean.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeInfoId",value = "员工ID: 新增页面：非必填   修改页面、查看详情页面：必填",paramType = "query"),
    })
    public ResultBo authlist(HttpSession session, Long employeeInfoId) throws Exception{
        return empAccNumService.authList(session,employeeInfoId);
//        ResultBo result = ResultBo.build();
//        List<RespEmpRoleInfoBean> list = new ArrayList<>();
//
//        TRoleInfoEntity entity1 = new TRoleInfoEntity();
//        RespEmpRoleInfoBean b1 = new RespEmpRoleInfoBean();
//        entity1.setfId(1);
//        entity1.setfName("系统管理员");
//        BeanUtils.copyProperties(entity1,b1);
//
//        TRoleInfoEntity entity2 = new TRoleInfoEntity();
//        RespEmpRoleInfoBean b2 = new RespEmpRoleInfoBean();
//        entity2.setfId(2);
//        entity2.setfName("业务负责人");
//        BeanUtils.copyProperties(entity2,b2);
//
//        list.add(b1);
//        list.add(b2);
//        result.setResultBody(list);
//        return result;
    }


}
