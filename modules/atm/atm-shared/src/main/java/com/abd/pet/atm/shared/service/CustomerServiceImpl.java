package com.abd.pet.atm.shared.service;

import com.abd.pet.atm.ejb.entity.CustomerDVO;
import com.abd.pet.atm.ejb.repo.CustomerRepository;
import com.abd.pet.atm.shared.model.UserModel;
import com.abd.pet.atm.shared.service.converter.CustomerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    public UserModel get(long id) {
        Optional<CustomerDVO> dvoOptional = customerRepository.findById(id);
        return customerConverter.dvoToModel(dvoOptional.orElse(null));
    }
}
