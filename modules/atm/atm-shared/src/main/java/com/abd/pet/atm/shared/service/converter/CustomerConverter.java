package com.abd.pet.atm.shared.service.converter;

import com.abd.pet.atm.ejb.entity.CustomerDVO;
import com.abd.pet.atm.shared.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class CustomerConverter implements IConverter<UserModel, CustomerDVO> {

    @Override
    public UserModel dvoToModel(CustomerDVO dvo) {
        if (dvo == null) {
            return null;
        }
        UserModel model = new UserModel();
        model.setId(dvo.getId());
        model.setName(dvo.getName());
        model.setSurname(dvo.getSurname());
        return model;
    }

    @Override
    public CustomerDVO modelToDVO(UserModel model) {
        if (model == null) {
            return null;
        }
        CustomerDVO dvo = new CustomerDVO();
        dvo.setId(model.getId());
        dvo.setName(model.getName());
        dvo.setSurname(model.getSurname());
        return dvo;
    }
}
