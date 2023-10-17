package com.abd.pet.atm.ejb.repo;

import com.abd.pet.atm.ejb.entity.AccountDVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountDVO, Long> {

    @Query("select acc from AccountDVO acc where acc.customer.id=:userId")
    List<AccountDVO> findByUserId(long userId);
}
