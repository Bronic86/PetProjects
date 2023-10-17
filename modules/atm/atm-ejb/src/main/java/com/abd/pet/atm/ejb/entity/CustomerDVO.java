package com.abd.pet.atm.ejb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerDVO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "identification_code", nullable = false)
    private String identificationCode;

    @OneToMany(mappedBy = "customer")
    private List<AccountDVO> accounts;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_pass_id")
    private CustomerPassDVO customerPass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public List<AccountDVO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDVO> accounts) {
        this.accounts = accounts;
    }

    public CustomerPassDVO getCustomerPass() {
        return customerPass;
    }

    public void setCustomerPass(CustomerPassDVO customerPwd) {
        this.customerPass = customerPwd;
    }
}
