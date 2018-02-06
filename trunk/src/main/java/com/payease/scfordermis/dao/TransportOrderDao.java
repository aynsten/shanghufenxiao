package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TTransportOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YHF on 2018/1/12.
 */
@Repository
public interface TransportOrderDao extends JpaRepository<TTransportOrderEntity, Long>, JpaSpecificationExecutor {


    List<TTransportOrderEntity> findByFSearchKeyContainingAndFCompanyId(String searchKey, Long companyId);

    List<TTransportOrderEntity> findByFAreaInfoIdOne(Long areaInfoLevel);

    List<TTransportOrderEntity> findByFAreaInfoIdTwo(Long areaInfoLevel);

    List<TTransportOrderEntity> findByFDriverPhone(String username);

    /**
     *     通过 f_driver_phone 司机手机号  f_status ForGoods-待提货 校验是否发送短线验证码
     */
    Integer countByFDriverPhoneAndFStatus(String fDriverPhone, String fStatus);
}
