package com.payease.scfordermis.service.impl;

import com.payease.scfordermis.bean.Status;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.PageBean;
import com.payease.scfordermis.bo.requestBo.ReqMsgListBean;
import com.payease.scfordermis.bo.responseBo.PageResponseCommBean;
import com.payease.scfordermis.bo.responseBo.app.customer.RespMsgUnReadBean;
import com.payease.scfordermis.dao.ConsumerMsgDao;
import com.payease.scfordermis.entity.TConsumerInfoEntity;
import com.payease.scfordermis.entity.TConsumerMsgEntity;
import com.payease.scfordermis.service.AppCustomerMsgService;
import com.payease.scfordermis.service.ICommPageHqlService;
import com.payease.scfordermis.service.LoginClientService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户端（app）- 消息
 * @Created By liuxiaoming
 * @CreateTime 2018/1/17 下午2:22
 **/
@Service
public class AppCustomerMsgServiceImpl implements AppCustomerMsgService {

    private static final Logger log = LoggerFactory.getLogger(AppCustomerMsgServiceImpl.class);

    @Autowired
    private ConsumerMsgDao consumerMsgDao;
    @Autowired
    private ICommPageHqlService commPageHqlService;
    @Autowired
    private LoginClientService loginClientService;
    /**
     * 未读消息个数
     */
    @Override
    public ResultBo unReadMsg(String token)  throws Exception{
        ResultBo result = ResultBo.build();
        try{
        if(StringUtils.isBlank(token)){return result.queryError();}
            TConsumerInfoEntity userInRedis = loginClientService.getUserInRedis(token);
            //通过token判断从Redis中是否获得参数
            if(userInRedis == null || Long.valueOf(userInRedis.getfCompanyId()) == null || Long.valueOf(userInRedis.getfId()) == null){return result.timeOut();}
            Long fCompanyId = Long.valueOf(userInRedis.getfCompanyId());//Long.valueOf(1);
            Long fConsumerId = Long.valueOf(userInRedis.getfId());//Long.valueOf(1);
        Integer unread = consumerMsgDao.countByFCompanyIdAndFConsumerIdAndFMsgStatus(fCompanyId, fConsumerId, "unread");
        RespMsgUnReadBean resp = new RespMsgUnReadBean();
        resp.setfMsgType("order");
        resp.setUnReadMsgNum(unread);
        result.setResultBody(resp);
    }catch (Exception e){
        e.printStackTrace();
        result.fail();
        log.error("AppCustomerMsgService - - unReadMsg :",e);
        throw e;
    }
        return result;
    }

    /**
     * 消息状态修改
     *  1."msgId",value = "消息ID： 若传all：全部已读"
     *  2.fMsgStatus "消息状态 read：已读 unread:未读",dataType = "string"
     */
    @Override
    public ResultBo updMsgStatus(String token, Long msgId)  throws Exception{

        ResultBo result = ResultBo.build();

        try{
            if(msgId == null || StringUtils.isBlank(token)){return result.queryError();}
           //通过传入token从Redis中获取客户信息
            TConsumerInfoEntity userInRedis = loginClientService.getUserInRedis(token);
        if(userInRedis == null || Long.valueOf(userInRedis.getfCompanyId()) == null || Long.valueOf(userInRedis.getfId()) == null){return result.timeOut();}
            Long fCompanyId = Long.valueOf(userInRedis.getfCompanyId());//Long.valueOf(1);
            Long fConsumerId = Long.valueOf(userInRedis.getfId());//Long.valueOf(1);

        if(msgId == -1){
            //查全部  全部标为已读
            List<TConsumerMsgEntity> list = consumerMsgDao.findByFCompanyIdAndFConsumerIdAndFMsgStatus(fCompanyId, fConsumerId, "unread");
            if(list==null||list.size()==0){return result;}
            for (TConsumerMsgEntity entity : list){
                entity.setfMsgStatus("read");
            }
            consumerMsgDao.save(list);
        }else{
            //查单一  单一消息标为已读
            TConsumerMsgEntity one = consumerMsgDao.findOne(msgId);
            if(one == null){
                log.error("AppCustomerMsgService - - updMsgStatus :"+Status.GETCONSUMERMSG.getMessage());
                return result.setCodeId(Status.GETCONSUMERMSG);
            }
            one.setfMsgStatus("read");
            consumerMsgDao.save(one);
        }
        }catch (Exception e){
            e.printStackTrace();
            result.fail();
            log.error("AppCustomerMsgService - - updMsgStatus :",e);
            throw e;
        }
        return result;
    }

    /**
     * 消息列表
     */
    @Override
    public ResultBo msgList(String token, ReqMsgListBean req)  throws Exception{
        ResultBo result = ResultBo.build();

        try{
        if(StringUtils.isBlank(token) || req == null || StringUtils.isBlank(req.getfMsgType())){ return result.queryError();}
            TConsumerInfoEntity userInRedis = loginClientService.getUserInRedis(token);
            //通过token判断从Redis中是否获得参数
            if(userInRedis == null || Long.valueOf(userInRedis.getfCompanyId()) == null || Long.valueOf(userInRedis.getfId()) == null){return result.timeOut();}
            Long fCompanyId = Long.valueOf(userInRedis.getfCompanyId());//Long.valueOf(1);
            Long fConsumerId = Long.valueOf(userInRedis.getfId());//Long.valueOf(1);
        //判断从Redis中是否获得参数
        if(fCompanyId == null || fConsumerId == null){return result.timeOut();}
        String sql = this.sqlBuf( req, "sql", fCompanyId, fConsumerId,req.getfMsgType());
        String sqlCount = this.sqlBuf( req, "sqlCount", fCompanyId, fConsumerId,req.getfMsgType());
        PageBean bean = new PageBean();
        bean.setSize(req.getSize());
        bean.setPage(req.getPage());
        PageResponseCommBean cbean = commPageHqlService.getPage(sql,sqlCount,bean);
        result.setResultBody(cbean);
        }catch (Exception e){
            e.printStackTrace();
            result.fail();
            log.error("AppCustomerMsgService - - msgList :",e);
            throw e;
        }
        return result;
    }

    //sql语句的拼接    type sql  sqlCount
    public String sqlBuf(ReqMsgListBean req,String type,long fCompanyId,long fConsumerId,String fMsgtype)  throws Exception{
        StringBuffer buf = new StringBuffer();
        if(type.equals("sql")){
            buf.append("SELECT new map( msg.fId AS fId , msg.fLinkId AS fLinkId , msg.fMsgTitle AS fMsgTitle , msg.fMsgDesc AS fMsgDesc , msg.fCreateTime AS fCreateTime , msg.fMsgType AS fMsgType , msg.fMsgStatus AS fMsgStatus) FROM TConsumerMsgEntity msg WHERE 1 = 1");
        }else if(type.equals("sqlCount")){
            buf.append("SELECT count(*) FROM TConsumerMsgEntity msg WHERE 1=1");
        }
        buf.append(" AND msg.fConsumerId ='").append(fConsumerId).append("'");
        buf.append(" AND msg.fCompanyId ='").append(fCompanyId).append("'");
        buf.append(" ORDER BY msg.fCreateTime DESC");
        return buf.toString();
    }
}
