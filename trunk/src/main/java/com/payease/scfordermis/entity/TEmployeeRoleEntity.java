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
@Table(name = "t_employee_role")
public class TEmployeeRoleEntity {
    private long fId;
    private long fEmployeeId;
    private long fRoleId;
    private Date fCreateTime;
    private Date fUpdateTime;
    private Long fOperare;
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
    @Column(name = "f_employee_id", nullable = false)
    public long getfEmployeeId() {
        return fEmployeeId;
    }

    public void setfEmployeeId(long fEmployeeId) {
        this.fEmployeeId = fEmployeeId;
    }

    @Basic
    @Column(name = "f_role_id", nullable = false)
    public long getfRoleId() {
        return fRoleId;
    }

    public void setfRoleId(long fRoleId) {
        this.fRoleId = fRoleId;
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
    @Column(name = "f_operare", nullable = true)
    public Long getfOperare() {
        return fOperare;
    }

    public void setfOperare(Long fOperare) {
        this.fOperare = fOperare;
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
        TEmployeeRoleEntity that = (TEmployeeRoleEntity) o;
        return fId == that.fId &&
                fEmployeeId == that.fEmployeeId &&
                fRoleId == that.fRoleId &&
                fCompanyId == that.fCompanyId &&
                Objects.equals(fCreateTime, that.fCreateTime) &&
                Objects.equals(fUpdateTime, that.fUpdateTime) &&
                Objects.equals(fOperare, that.fOperare);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fId, fEmployeeId, fRoleId, fCreateTime, fUpdateTime, fOperare, fCompanyId);
    }
}
