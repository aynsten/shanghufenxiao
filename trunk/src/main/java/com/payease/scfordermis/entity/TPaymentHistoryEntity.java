package com.payease.scfordermis.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @Author : zhangwen
 * @Data : 2018/1/10
 * @Description :
 */
@Entity
@Table(name = "t_payment_history")
public class TPaymentHistoryEntity {
    private long id;
    private String fPayNum;
    private Date fCreatetime;
    private BigDecimal fAmount;
    private String fPaymethod;
    private String fPayStatus;
    private String fRemark;
    private Long fCompanyId;
    private long fOrderId;

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
    @Column(name = "f_pay_num", nullable = false, length = 80)
    public String getfPayNum() {
        return fPayNum;
    }

    public void setfPayNum(String fPayNum) {
        this.fPayNum = fPayNum;
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
    @Column(name = "f_amount", nullable = false, precision = 2)
    public BigDecimal getfAmount() {
        return fAmount;
    }

    public void setfAmount(BigDecimal fAmount) {
        this.fAmount = fAmount;
    }

    @Basic
    @Column(name = "f_paymethod", nullable = false, length = 20)
    public String getfPaymethod() {
        return fPaymethod;
    }

    public void setfPaymethod(String fPaymethod) {
        this.fPaymethod = fPaymethod;
    }

    @Basic
    @Column(name = "f_pay_status", nullable = false, length = 20)
    public String getfPayStatus() {
        return fPayStatus;
    }

    public void setfPayStatus(String fPayStatus) {
        this.fPayStatus = fPayStatus;
    }

    @Basic
    @Column(name = "f_remark", nullable = true, length = 500)
    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark;
    }

    @Basic
    @Column(name = "f_company_id", nullable = true)
    public Long getfCompanyId() {
        return fCompanyId;
    }

    public void setfCompanyId(Long fCompanyId) {
        this.fCompanyId = fCompanyId;
    }

    @Basic
    @Column(name = "f_order_id", nullable = false)
    public long getfOrderId() {
        return fOrderId;
    }

    public void setfOrderId(long fOrderId) {
        this.fOrderId = fOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TPaymentHistoryEntity that = (TPaymentHistoryEntity) o;
        return id == that.id &&
                fOrderId == that.fOrderId &&
                Objects.equals(fPayNum, that.fPayNum) &&
                Objects.equals(fCreatetime, that.fCreatetime) &&
                Objects.equals(fAmount, that.fAmount) &&
                Objects.equals(fPaymethod, that.fPaymethod) &&
                Objects.equals(fPayStatus, that.fPayStatus) &&
                Objects.equals(fRemark, that.fRemark) &&
                Objects.equals(fCompanyId, that.fCompanyId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fPayNum, fCreatetime, fAmount, fPaymethod, fPayStatus, fRemark, fCompanyId, fOrderId);
    }
}
