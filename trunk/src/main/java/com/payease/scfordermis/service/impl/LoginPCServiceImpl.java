package com.payease.scfordermis.service.impl;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.payease.scfordermis.bean.Status;
import com.payease.scfordermis.bo.MenuBo;
import com.payease.scfordermis.bo.MenuListBo;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqLoginPCBean;
import com.payease.scfordermis.bo.responseBo.RespLoginPCBean;
import com.payease.scfordermis.dao.DepartmentInfoDao;
import com.payease.scfordermis.dao.EmployeeInfoDao;
import com.payease.scfordermis.dao.EmployeeRoleDao;
import com.payease.scfordermis.dao.RoleInfoDao;
import com.payease.scfordermis.entity.TDepartmentInfoEntity;
import com.payease.scfordermis.entity.TEmployeeInfoEntity;
import com.payease.scfordermis.entity.TEmployeeRoleEntity;
import com.payease.scfordermis.entity.TRoleInfoEntity;
import com.payease.scfordermis.service.LoginPCService;
import com.payease.scfordermis.utils.MD5;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * Created by zhoushijie on 2018/1/15.
 */
@Service
public class LoginPCServiceImpl implements LoginPCService {
    private static final Logger log = LoggerFactory.getLogger(LoginPCServiceImpl.class);
    @Autowired
    EmployeeInfoDao employeeInfoDao;
    @Autowired
    EmployeeRoleDao employeeRoleDao;
    @Autowired
    RoleInfoDao roleInfoDao;
    @Autowired
    DepartmentInfoDao departmentInfoDao;

    /**
     * 登录
     * @param session
     * @param reqLoginPCBean
     * @return
     * @throws Exception
     */
    @Override
    public ResultBo login(HttpSession session,ReqLoginPCBean reqLoginPCBean)throws Exception{
        ResultBo result =ResultBo.build();
        try{
            //判断是否为空
            //判断是否是空值
            if (reqLoginPCBean == null){
                return result.setCodeId(Status.QUERYERROR);
            }
            //判断账号是否是空值
            if (StringUtils.isBlank(reqLoginPCBean.getfAccount())){
                return result.setCodeId(Status.CHECKACCOUNTSTATUS);
            }
            //判断是密码否是空值
            if (StringUtils.isBlank(reqLoginPCBean.getfPassword())){
                return result.setCodeId(Status.CHECKPWDNULL);
            }
            //根据用户名查询用户信息
            List<TEmployeeInfoEntity> list = employeeInfoDao.findByFAccountOrFMobile(reqLoginPCBean.getfAccount(),reqLoginPCBean.getfAccount());
            if (list == null || list.size()==0){
                return result.setCodeId(Status.CHECKACCOUNTSTATUS);
            }

            //获取数据库中对象
            TEmployeeInfoEntity entity = list.get(0);
            if (entity == null){
                return result.setCodeId(Status.CHECKISNULL);
            }

            //  账号状态  open-开通 close-禁用     yes-删除 no-未删除
            if ("open".equals(entity.getfStatus()) && "no".equals(entity.getfIsDelete())){
                //账号状态开通,信息未删除    可以登录
                // 验证密码  判断密码是否正确    入参pwd 进行加密                   数据库存储pwd
                if (MD5.encode(reqLoginPCBean.getfPassword()).equals(entity.getfPassword())) {
                    //获取用户信息
                    result = getUserInfo(session, entity);
                }else {
                    return result.setCodeId(Status.CHECKPWDERROR);
                }
                return result;
            }else {
                //获取账号状态失败与账号已删除  不可以登录
                return result.setCodeId(Status.ACCSTATUSERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("loginError",e);
            result.setCodeId(Status.QUERYERROR);
            throw e;
        }
    }





    /**
     * 用户信息获取
     * @param session
     * @param entity
     * @return
     * @throws Exception
     */
    private ResultBo getUserInfo(HttpSession session,TEmployeeInfoEntity entity)throws Exception{
        ResultBo result = ResultBo.build();
        RespLoginPCBean resp = new RespLoginPCBean();//出参对象
        //获取姓名
        resp.setfName(entity.getfName());
        // 通过员工ID 查员工角色关系（t_employee_role）表中的角色ID  再通过角色ID查角色信息（t_role_info）表中的菜单权限
        //查找角色id
        List<TEmployeeRoleEntity> byFEmployeeIdList = employeeRoleDao.findByFEmployeeId(entity.getfId());
        if (byFEmployeeIdList == null || byFEmployeeIdList.size() ==0){
            return result.setCodeId(Status.EMPLOYEEROLEERROR);
        }
        //查找角色关系id
        List<String> strList = new ArrayList<>();
        for (TEmployeeRoleEntity ERentity : byFEmployeeIdList){
            TRoleInfoEntity one = roleInfoDao.findOne(ERentity.getfRoleId());
            if(one == null){
                return result.setCodeId(Status.CHECKROLEIDERROR);
            }
            // 获取菜单权限 选中状态的字符串
            List<MenuBo> menuBos = JSON.parseArray(one.getfMenus(),MenuBo.class);
            if(menuBos == null || menuBos.size() == 0){
                return result.setCodeId(Status.JSONMENUPARSEERROR);
            }
            for(MenuBo bo : menuBos){
                if(bo.getCodeSelect().equals(true)){
                    strList.add(bo.getCodeId());
                }
            }
        }
        //菜单去重
        List<String> list = this.SETMenuList(strList);
        resp.setfMenus(JSON.toJSONString(list));

        resp.setfAccount(entity.getfAccount());//账号
        resp.setfDepartId(String.valueOf(entity.getfDepartIdTwo()));//获取部门id
        //部门名称 通过部门id查询部门表(TDepartmentInfo)
        TDepartmentInfoEntity departmentInfoEntity = departmentInfoDao.findOne(entity.getfDepartIdTwo());
        if (departmentInfoEntity ==null){
            return result.setCodeId(Status.CHECKDEPARTMENTINFOERROR);
        }
        resp.setfDepartName(departmentInfoEntity.getfName());
        resp.setfPosition(entity.getfPosition());
        resp.setfName(entity.getfName());
        resp.setfMobile(entity.getfMobile());
        resp.setfEmail(entity.getfEmail());
        resp.setfQq(entity.getfQq());
        resp.setfCompanyId(entity.getfCompanyId());
        resp.setfId(entity.getfId());
        resp.setfStatus(entity.getfStatus());
        resp.setfIsDelete(entity.getfIsDelete());
        session.setAttribute("userInfo",resp);
        result.setResultBody(resp);
        return result;
    }


    /**
     *  菜单集合去重
     */

    private List<String> SETMenuList(List<String> list) throws Exception{
        Set<Object> set = new HashSet<>();
        List<String> newList = new ArrayList<>();

        for (String str : list) {
            if (set.add(str)) {
                newList.add(str);
            }
        }
        return newList;
    }




    //==================================================================================================
    /**
     * 登出
     * @return
     */
    @Override
    public ResultBo logout(HttpSession session) throws Exception{
        ResultBo result=ResultBo.build();
        try{
            session.removeAttribute("userInfo");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            log.error("logoutError",e);
            result.setCodeId(Status.LOGOUTERROR);
            throw e;
        }
    }
}



