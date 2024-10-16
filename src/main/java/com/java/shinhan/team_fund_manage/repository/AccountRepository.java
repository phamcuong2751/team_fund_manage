package com.java.shinhan.team_fund_manage.repository;

import com.java.shinhan.team_fund_manage.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
