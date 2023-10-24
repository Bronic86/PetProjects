package com.abd.pet.atm.shared.model;

import com.abd.pet.atm.ejb.entity.CustomerDVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomerPrinciple implements UserDetails {
    private static final long serialVersionUID = 1L;

    private final Long id;

    private final String name;

    private final String username;

    private final String email;

    @JsonIgnore
    private final String password;

    private final Collection<? extends GrantedAuthority> authorities;

    public CustomerPrinciple(Long id, String name,
                         String username, String email, String password,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static CustomerPrinciple build(CustomerDVO customer) {
        List<GrantedAuthority> authorities = customer.getRoles().stream().map(role ->
                                                                                  new SimpleGrantedAuthority(role.getName())
        ).collect(Collectors.toList());

        return new CustomerPrinciple(
                customer.getId(),
                customer.getName(),
                customer.getUsername(),
                customer.getEmail(),
               customer.getCustomerPass().getPwd(),
                           authorities
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerPrinciple user = (CustomerPrinciple) o;
        return Objects.equals(id, user.id);
    }
}
