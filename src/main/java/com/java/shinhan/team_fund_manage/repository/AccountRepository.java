package com.java.shinhan.team_fund_manage.repository;

import com.java.shinhan.team_fund_manage.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    boolean existsByAccountNoAndMember_Id(String accountNo, Long memberID);
    boolean existsByAccountNoAndBankCode(String accountNo,String bankCode);
    Optional<AccountEntity> findByAccountNo(String accountNo);
}
