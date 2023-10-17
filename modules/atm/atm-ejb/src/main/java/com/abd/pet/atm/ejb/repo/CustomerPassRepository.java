package com.abd.pet.atm.ejb.repo;

import com.abd.pet.atm.ejb.entity.CustomerPassDVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPassRepository extends JpaRepository<CustomerPassDVO, Long> {

}
