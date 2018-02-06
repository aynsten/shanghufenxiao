package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqCustomerBean;
import com.payease.scfordermis.bo.requestBo.ReqMyCustomerTwoBo;
import com.payease.scfordermis.bo.responseBo.RespCustomerBean;
import com.payease.scfordermis.entity.TConsumerInfoEntity;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2018/1/10.
 */
public interface CustomerService {

    ResultBo selectIndext(ReqCustomerBean reqCustomerBean,HttpSession session) throws Exception;

    ResultBo getDetail(long id) throws Exception;

    void isDelete(HttpSession session,long fid) throws Exception;

    ResultBo upAndSave(HttpSession session, ReqMyCustomerTwoBo reqMyCustomerTwoBo) throws Exception;

}
