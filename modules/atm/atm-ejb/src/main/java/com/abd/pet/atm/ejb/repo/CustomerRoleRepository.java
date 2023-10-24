package com.abd.pet.atm.ejb.repo;

import com.abd.pet.atm.ejb.entity.CustomerDVO;
import com.abd.pet.atm.ejb.entity.RoleDVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRoleRepository extends JpaRepository<RoleDVO, Long> {
    Optional<RoleDVO> findByName(String roleName);
}
