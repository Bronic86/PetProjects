package com.abd.pet.atm.ejb.repo;

import com.abd.pet.atm.ejb.entity.CustomerDVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDVO, Long> {

}
