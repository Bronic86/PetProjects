package com.abd.pet.atm.ejb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
public class CustomerDVO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "identification_code", nullable = false)
    private String identificationCode;

    @OneToMany(mappedBy = "customer")
    private List<AccountDVO> accounts;

    @OneToOne(fetch = FetchType.EAGER)
    private CustomerPassDVO customerPass;

    @OneToMany(mappedBy = "customer")
    private List<RoleDVO> roles = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleDVO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDVO> roles) {
        this.roles = roles;
    }
}
