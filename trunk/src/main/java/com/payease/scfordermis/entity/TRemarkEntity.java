package com.payease.scfordermis.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @Author : zhangwen
 * @Data : 2018/1/11
 * @Description :
 */
@Entity
@Table(name = "t_remark")
public class TRemarkEntity {
    private long id;
    private String fContent;
    private Date fCreatetime;
    private long fOperaterId;
    private String tType;
    private long tCompanyId;
    private String tRemarkcol;
    private long fTransportOrderId;

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
    @Column(name = "f_content", nullable = false, length = 500)
    public String getfContent() {
        return fContent;
    }

    public void setfContent(String fContent) {
        this.fContent = fContent;
    }

    @Basic
    @Column(name = "f_createtime", nullable = true)
    public Date getfCreatetime() {
        return fCreatetime;
    }

    public void setfCreatetime(Date fCreatetime) {
        this.fCreatetime = fCreatetime;
    }

    @Basic
    @Column(name = "f_operater_id", nullable = false)
    public long getfOperaterId() {
        return fOperaterId;
    }

    public void setfOperaterId(long fOperaterId) {
        this.fOperaterId = fOperaterId;
    }

    @Basic
    @Column(name = "t_type", nullable = false, length = 20)
    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType;
    }

    @Basic
    @Column(name = "t_company_id", nullable = false)
    public long gettCompanyId() {
        return tCompanyId;
    }

    public void settCompanyId(long tCompanyId) {
        this.tCompanyId = tCompanyId;
    }

    @Basic
    @Column(name = "t_remarkcol", nullable = true, length = 45)
    public String gettRemarkcol() {
        return tRemarkcol;
    }

    public void settRemarkcol(String tRemarkcol) {
        this.tRemarkcol = tRemarkcol;
    }

    @Basic
    @Column(name = "f_transport_order_id", nullable = false)
    public long getfTransportOrderId() {
        return fTransportOrderId;
    }

    public void setfTransportOrderId(long fTransportOrderId) {
        this.fTransportOrderId = fTransportOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TRemarkEntity that = (TRemarkEntity) o;
        return id == that.id &&
                fOperaterId == that.fOperaterId &&
                tCompanyId == that.tCompanyId &&
                fTransportOrderId == that.fTransportOrderId &&
                Objects.equals(fContent, that.fContent) &&
                Objects.equals(fCreatetime, that.fCreatetime) &&
                Objects.equals(tType, that.tType) &&
                Objects.equals(tRemarkcol, that.tRemarkcol);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fContent, fCreatetime, fOperaterId, tType, tCompanyId, tRemarkcol, fTransportOrderId);
    }
}
