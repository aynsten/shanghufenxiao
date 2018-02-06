package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.requestBo.ReqDistributionOrderBo;
import com.payease.scfordermis.bo.requestBo.ReqSaveOrUpdateOrderBo;
import com.payease.scfordermis.bo.responseBo.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by lch on 2018/1/15.
 * <p>
 * 集散地订单service接口
 */
public interface IOrderService {

    Page<RespDistributionOrderBo> orderList(RespLoginPCBean respLoginPCBean, ReqDistributionOrderBo reqDistributionOrderBo);

    List<RespCustomerLevelBo> customerLevelList(RespLoginPCBean respLoginPCBean);

    List<RespAreaInfoBo> salesAreaList(RespLoginPCBean respLoginPCBean);

    List<RespDistributionBo> transportList(RespLoginPCBean respLoginPCBean);

    List<RespCustomerBo> customerList(RespLoginPCBean respLoginPCBean);

    List<RespProductBo> productList(Long transportId);

    List<RespOperationLogBo> noteList(Long orderId);

    void addRemark(RespLoginPCBean respLoginPCBean, Long orderId, String content);

    RespOrderDetailsBo orderDetails(Long orderId);

    List<RspPaymentRecordsBo> paymentRecords(Long orderId);

    void orderReviewOrCancellation(RespLoginPCBean respLoginPCBean, Long orderId, String type, String cancellationReason);

    void orderSaveOrUpdate(RespLoginPCBean respLoginPCBean, ReqSaveOrUpdateOrderBo reqSaveOrUpdateOrderBo);
}
