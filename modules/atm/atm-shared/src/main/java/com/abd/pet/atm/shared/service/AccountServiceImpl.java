package com.abd.pet.atm.shared.service;

import com.abd.pet.atm.ejb.entity.AccountDVO;
import com.abd.pet.atm.ejb.repo.AccountRepository;
import com.abd.pet.atm.ejb.repo.CustomerRepository;
import com.abd.pet.atm.shared.model.AccountModel;
import com.abd.pet.atm.shared.service.converter.AccountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository  accountRepository;

    private CustomerRepository customerRepository;

    private AccountConverter   accountConverter;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setAccountConverter(AccountConverter accountConverter) {
        this.accountConverter = accountConverter;
    }

    @Transactional
    public AccountModel createAccount(long userId) {
        AccountDVO dvo = new AccountDVO();
        dvo.setCode(UUID.randomUUID().toString());
        dvo.setCustomer(customerRepository.getReferenceById(userId));
        dvo = accountRepository.save(dvo);
        return accountConverter.dvoToModel(dvo);
    }

    public AccountModel get(long id) {
        Optional<AccountDVO> dvoOptional = accountRepository.findById(id);
        return dvoOptional.map(accountDVO -> accountConverter.dvoToModel(accountDVO)).orElse(null);
    }

    public List<AccountModel> getByUserId(long userId) {
        List<AccountDVO> dvos = accountRepository.findByUserId(userId);
        List<AccountModel> models = new ArrayList<>();
        if (dvos != null) {
            for (AccountDVO dvo : dvos) {
                models.add(accountConverter.dvoToModel(dvo));
            }
        }
        return models;
    }

}
