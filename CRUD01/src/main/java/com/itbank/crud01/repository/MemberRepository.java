package com.itbank.crud01.repository;

import com.itbank.crud01.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUseridAndUserpw(String userid, String userpw);
}
