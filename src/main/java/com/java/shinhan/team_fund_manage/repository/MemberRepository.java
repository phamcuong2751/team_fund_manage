package com.java.shinhan.team_fund_manage.repository;

import com.java.shinhan.team_fund_manage.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    List<MemberEntity> findByNameLikeAndStatusIsNot(String name, String status);
}
