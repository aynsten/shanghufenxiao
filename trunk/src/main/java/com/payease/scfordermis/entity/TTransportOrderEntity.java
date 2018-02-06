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
@Table(name = "t_transport_order")
public class TTransportOrderEntity {
    private long id;
    private String fTransportNum;
    private long fAreaInfoIdOne;
    private long fAreaInfoIdTwo;
    private Date fCreatetime;
    private String fCarNum;
    private String fDriverName;
    private String fDriverPhone;
    private String fStatus;
    private long fCompanyId;
    private long fOperate;
    private Date fUpdateTime;
    private String fSearchKey;
    private String fCustomsFormNo;

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
    @Column(name = "f_transport_num", nullable = true, length = 45)
    public String getfTransportNum() {
        return fTransportNum;
    }

    public void setfTransportNum(String fTransportNum) {
        this.fTransportNum = fTransportNum;
    }

    @Basic
    @Column(name = "f_area_info_id_one", nullable = false)
    public long getfAreaInfoIdOne() {
        return fAreaInfoIdOne;
    }

    public void setfAreaInfoIdOne(long fAreaInfoIdOne) {
        this.fAreaInfoIdOne = fAreaInfoIdOne;
    }

    @Basic
    @Column(name = "f_area_info_id_two", nullable = false)
    public long getfAreaInfoIdTwo() {
        return fAreaInfoIdTwo;
    }

    public void setfAreaInfoIdTwo(long fAreaInfoIdTwo) {
        this.fAreaInfoIdTwo = fAreaInfoIdTwo;
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
    @Column(name = "f_car_num", nullable = false, length = 20)
    public String getfCarNum() {
        return fCarNum;
    }

    public void setfCarNum(String fCarNum) {
        this.fCarNum = fCarNum;
    }

    @Basic
    @Column(name = "f_driver_name", nullable = false, length = 10)
    public String getfDriverName() {
        return fDriverName;
    }

    public void setfDriverName(String fDriverName) {
        this.fDriverName = fDriverName;
    }

    @Basic
    @Column(name = "f_driver_phone", nullable = false, length = 15)
    public String getfDriverPhone() {
        return fDriverPhone;
    }

    public void setfDriverPhone(String fDriverPhone) {
        this.fDriverPhone = fDriverPhone;
    }

    @Basic
    @Column(name = "f_status", nullable = false, length = 20)
    public String getfStatus() {
        return fStatus;
    }

    public void setfStatus(String fStatus) {
        this.fStatus = fStatus;
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
    @Column(name = "f_operate", nullable = false)
    public long getfOperate() {
        return fOperate;
    }

    public void setfOperate(long fOperate) {
        this.fOperate = fOperate;
    }

    @Basic
    @Column(name = "f_update_time", nullable = true)
    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    @Basic
    @Column(name = "f_search_key", nullable = false, length = 300)
    public String getfSearchKey() {
        return fSearchKey;
    }

    public void setfSearchKey(String fSearchKey) {
        this.fSearchKey = fSearchKey;
    }

    @Basic
    @Column(name = "f_customs_form_no", nullable = false, length = 100)
    public String getfCustomsFormNo() {
        return fCustomsFormNo;
    }

    public void setfCustomsFormNo(String fCustomsFormNo) {
        this.fCustomsFormNo = fCustomsFormNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TTransportOrderEntity that = (TTransportOrderEntity) o;
        return id == that.id &&
                fAreaInfoIdOne == that.fAreaInfoIdOne &&
                fAreaInfoIdTwo == that.fAreaInfoIdTwo &&
                fCompanyId == that.fCompanyId &&
                fOperate == that.fOperate &&
                Objects.equals(fTransportNum, that.fTransportNum) &&
                Objects.equals(fCreatetime, that.fCreatetime) &&
                Objects.equals(fCarNum, that.fCarNum) &&
                Objects.equals(fDriverName, that.fDriverName) &&
                Objects.equals(fDriverPhone, that.fDriverPhone) &&
                Objects.equals(fStatus, that.fStatus) &&
                Objects.equals(fUpdateTime, that.fUpdateTime) &&
                Objects.equals(fSearchKey, that.fSearchKey) &&
                Objects.equals(fCustomsFormNo, that.fCustomsFormNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fTransportNum, fAreaInfoIdOne, fAreaInfoIdTwo, fCreatetime, fCarNum, fDriverName, fDriverPhone, fStatus, fCompanyId, fOperate, fUpdateTime, fSearchKey, fCustomsFormNo);
    }
}
