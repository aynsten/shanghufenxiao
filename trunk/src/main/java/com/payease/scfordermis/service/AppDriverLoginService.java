package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.responseBo.app.driver.RespAppDriverLoginBean;
import com.payease.scfordermis.entity.TTransportOrderEntity;

/**
 * Created by admin on 2018/1/23.
 * 司机端登录
 */
public interface AppDriverLoginService {
    //登录
    ResultBo login(String username, String code) throws Exception;

    //自动登录
    ResultBo autoLogin(String token) throws Exception;

    //根据token获取redis中的用户信息
    RespAppDriverLoginBean getUserInRedis(String token) throws Exception;

    //登出
    ResultBo logout(String token) throws Exception;
}
