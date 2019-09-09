package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Acntwg")
@Table(name = "viw_acntwg")
public class Acntwg {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;/*only for debug*/
    @Column(updatable = false)
    private String acntno;
    //@Column(insertable = false, updatable = false)
    private Date trndate;
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

    public Date getTrndate() {
        return trndate;
    }

    public void setTrndate(Date trndate) {
        this.trndate = trndate;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }
}
