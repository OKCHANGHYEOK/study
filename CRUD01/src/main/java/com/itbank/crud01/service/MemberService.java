package com.itbank.crud01.service;


import com.itbank.crud01.model.Member;
import com.itbank.crud01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository mp;


    public Member join(Member member) {
        return mp.save(member);
    }

    public Member login(Member member) {
        return mp.findByUseridAndUserpw(member.getUserid(), member.getUserpw());
    }
}
