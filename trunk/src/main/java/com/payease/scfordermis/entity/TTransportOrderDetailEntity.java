package com.payease.scfordermis.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @Author : zhangwen
 * @Data : 2018/1/10
 * @Description :
 */
@Entity
@Table(name = "t_transport_order_detail")
public class TTransportOrderDetailEntity {
    private long id;
    private long fTransportOrderId;
    private long fProductId;
    private int fPlanNumber;
    private int fSurplusNumber;
    private Date fCreatetime;
    private long fOperate;
    private long fCompanyId;
    private long tProductFormatId;
    private Long tUnitInfoId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "f_transport_order_id", nullable = false)
    public long getfTransportOrderId() {
        return fTransportOrderId;
    }

    public void setfTransportOrderId(long fTransportOrderId) {
        this.fTransportOrderId = fTransportOrderId;
    }

    @Basic
    @Column(name = "f_product_id", nullable = false)
    public long getfProductId() {
        return fProductId;
    }

    public void setfProductId(long fProductId) {
        this.fProductId = fProductId;
    }

    @Basic
    @Column(name = "f_plan_number", nullable = false)
    public int getfPlanNumber() {
        return fPlanNumber;
    }

    public void setfPlanNumber(int fPlanNumber) {
        this.fPlanNumber = fPlanNumber;
    }

    @Basic
    @Column(name = "f_surplus_number", nullable = false)
    public int getfSurplusNumber() {
        return fSurplusNumber;
    }

    public void setfSurplusNumber(int fSurplusNumber) {
        this.fSurplusNumber = fSurplusNumber;
    }

    @Basic
    @Column(name = "f_createtime", nullable = false)
    public Date getfCreatetime() {
        return fCreatetime;
    }

    public void setfCreatetime(Date fCreatetime) {
        this.fCreatetime = fCreatetime;
    }

    @Basic
    @Column(name = "f_operate", nullable = false)
    public long getfOperate() {
        return fOperate;
    }

    public void setfOperate(long fOperate) {
        this.fOperate = fOperate;
    }

    @Basic
    @Column(name = "f_company_id", nullable = false)
    public long getfCompanyId() {
        return fCompanyId;
    }

    public void setfCompanyId(long fCompanyId) {
        this.fCompanyId = fCompanyId;
    }

    @Basic
    @Column(name = "t_product_format_id", nullable = false)
    public long gettProductFormatId() {
        return tProductFormatId;
    }

    public void settProductFormatId(long tProductFormatId) {
        this.tProductFormatId = tProductFormatId;
    }

    @Basic
    @Column(name = "t_unit_info_id", nullable = true)
    public Long gettUnitInfoId() {
        return tUnitInfoId;
    }

    public void settUnitInfoId(Long tUnitInfoId) {
        this.tUnitInfoId = tUnitInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TTransportOrderDetailEntity that = (TTransportOrderDetailEntity) o;
        return id == that.id &&
                fTransportOrderId == that.fTransportOrderId &&
                fProductId == that.fProductId &&
                fPlanNumber == that.fPlanNumber &&
                fSurplusNumber == that.fSurplusNumber &&
                fOperate == that.fOperate &&
                fCompanyId == that.fCompanyId &&
                tProductFormatId == that.tProductFormatId &&
                Objects.equals(fCreatetime, that.fCreatetime) &&
                Objects.equals(tUnitInfoId, that.tUnitInfoId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fTransportOrderId, fProductId, fPlanNumber, fSurplusNumber, fCreatetime, fOperate, fCompanyId, tProductFormatId, tUnitInfoId);
    }
}
