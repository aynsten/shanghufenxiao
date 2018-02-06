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
@Table(name = "t_product_format")
public class TProductFormatEntity {
    private long fId;
    private long fProductId;
    private String fName;
    private String fPic;
    private String fCode;
    private String fPrice;
    private Date fCreateTime;
    private Date fUpdateTime;
    private Long fOperate;
    private long fCompanyId;

    @Id
    @Column(name = "f_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getfId() {
        return fId;
    }

    public void setfId(long fId) {
        this.fId = fId;
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
    @Column(name = "f_name", nullable = false, length = 20)
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Basic
    @Column(name = "f_pic", nullable = false, length = 100)
    public String getfPic() {
        return fPic;
    }

    public void setfPic(String fPic) {
        this.fPic = fPic;
    }

    @Basic
    @Column(name = "f_code", nullable = false, length = 50)
    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    @Basic
    @Column(name = "f_price", nullable = false, length = 20)
    public String getfPrice() {
        return fPrice;
    }

    public void setfPrice(String fPrice) {
        this.fPrice = fPrice;
    }

    @Basic
    @Column(name = "f_create_time", nullable = false)
    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
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
    @Column(name = "f_operate", nullable = true)
    public Long getfOperate() {
        return fOperate;
    }

    public void setfOperate(Long fOperate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TProductFormatEntity that = (TProductFormatEntity) o;
        return fId == that.fId &&
                fProductId == that.fProductId &&
                fCompanyId == that.fCompanyId &&
                Objects.equals(fName, that.fName) &&
                Objects.equals(fPic, that.fPic) &&
                Objects.equals(fCode, that.fCode) &&
                Objects.equals(fPrice, that.fPrice) &&
                Objects.equals(fCreateTime, that.fCreateTime) &&
                Objects.equals(fUpdateTime, that.fUpdateTime) &&
                Objects.equals(fOperate, that.fOperate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fId, fProductId, fName, fPic, fCode, fPrice, fCreateTime, fUpdateTime, fOperate, fCompanyId);
    }
}
