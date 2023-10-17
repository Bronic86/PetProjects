package com.abd.pet.atm.ejb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "customer_pass")
public class CustomerPassDVO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customerPass")
    @JoinColumn(name = "customer_id")
    private CustomerDVO customer;

    @Column(name = "pwd", nullable = false)
    private byte[] pwd;

    @Column(name = "change_ts", nullable = false)
    private Timestamp changeTs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDVO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDVO customer) {
        this.customer = customer;
    }

    public byte[] getPwd() {
        return pwd;
    }

    public void setPwd(byte[] pwd) {
        this.pwd = pwd;
    }

    public Timestamp getChangeTs() {
        return changeTs;
    }

    public void setChangeTs(Timestamp changeTs) {
        this.changeTs = changeTs;
    }
}
