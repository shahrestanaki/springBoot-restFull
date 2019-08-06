package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Acntwg")
@Table(name = "viw_acntwg")
public class Acntwg {
    @Id
    private Integer id;/*only for debug*/
    @Column(insertable = false, updatable = false)
    private String acntno;
    @Column(insertable = false, updatable = false)
    private String trndate;
    private Double wage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcntno() {
        return acntno;
    }

    public void setAcntno(String acntno) {
        this.acntno = acntno;
    }

    public String getTrndate() {
        return trndate;
    }

    public void setTrndate(String trndate) {
        this.trndate = trndate;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }
}
