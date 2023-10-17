package com.abd.pet.atm.shared.service.converter;

import com.abd.pet.atm.ejb.entity.AccountDVO;
import com.abd.pet.atm.ejb.repo.CustomerRepository;
import com.abd.pet.atm.shared.model.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountConverter implements IConverter<AccountModel, AccountDVO> {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public AccountModel dvoToModel(AccountDVO dvo) {
        if (dvo == null) {
            return null;
        }
        AccountModel model = new AccountModel();
        model.setId(dvo.getId());
        model.setAccountId(dvo.getCode());
        model.setCustomerId(dvo.getCustomer().getId());
        model.setQuantity(dvo.getValue());
        return model;
    }

    @Override
    public AccountDVO modelToDVO(AccountModel model) {
        if (model == null) {
            return null;
        }
        AccountDVO dvo = new AccountDVO();
        dvo.setId(model.getId());
        dvo.setCode(model.getAccountId());
        dvo.setValue(model.getQuantity());
        dvo.setCustomer(model.getCustomerId() == 0 ? null : customerRepository.getReferenceById(model.getCustomerId()));
        return dvo;
    }
}
