package com.abd.pet.atm.shared.service;

import com.abd.pet.atm.shared.model.CustomerPrinciple;
import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

    CustomerPrinciple checkUser(String username, String password);
}
