package com.abd.pet.atm.shared.service;

import com.abd.pet.atm.ejb.entity.CustomerDVO;
import com.abd.pet.atm.ejb.repo.CustomerRepository;
import com.abd.pet.atm.shared.model.CustomerPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private CustomerRepository customerRepository;

//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        CustomerDVO dvo = customerRepository.findByName(username);
//
//        if(dvo == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
//
//        return new User(dvo.getName(), new String(dvo.getCustomerPass().getPwd(), StandardCharsets.UTF_8), authorities);
//    }

    @Override
    @Transactional
    public CustomerPrinciple checkUser(String username, String password) {
        CustomerDVO dvo = customerRepository.findByUsername(username);

        if(dvo == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        if (!Objects.equals(password, dvo.getCustomerPass().getPwd())) {
            throw new AuthenticationCredentialsNotFoundException("User " + username + " not found or has incorrect credentials");
        }

        return CustomerPrinciple.build(dvo);
    }
}
