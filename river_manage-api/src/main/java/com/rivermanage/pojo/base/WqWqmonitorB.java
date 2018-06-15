package com.rivermanage.pojo.base;

import java.io.Serializable;
import java.math.BigDecimal;

public class WqWqmonitorB implements Serializable {
    private Integer id;

    private String stcd;

    private Integer devid;

    private Integer parid;

    private String spt;

    private BigDecimal mtda;

    private String nt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStcd() {
        return stcd;
    }

    public void setStcd(String stcd) {
        this.stcd = stcd == null ? null : stcd.trim();
    }

    public Integer getDevid() {
        return devid;
    }

    public void setDevid(Integer devid) {
        this.devid = devid;
    }

    public Integer getParid() {
        return parid;
    }

    public void setParid(Integer parid) {
        this.parid = parid;
    }

    public String getSpt() {
        return spt;
    }

    public void setSpt(String spt) {
        this.spt = spt == null ? null : spt.trim();
    }

    public BigDecimal getMtda() {
        return mtda;
    }

    public void setMtda(BigDecimal mtda) {
        this.mtda = mtda;
    }

    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt == null ? null : nt.trim();
    }
}