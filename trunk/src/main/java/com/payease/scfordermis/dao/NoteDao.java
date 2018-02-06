package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lch on 2018/1/16.
 *
 * 操作日志dao
 */
public interface NoteDao extends JpaRepository<TNoteEntity, Long> {

    List<TNoteEntity> findByFTransportOrderIdAndFType(Long orderId,String type);
}
