package com.abd.pet.atm.shared.service.converter;

public interface IConverter<M, D> {

    M dvoToModel(D dvo);

    D modelToDVO(M model);
}
