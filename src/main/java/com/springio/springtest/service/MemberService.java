package com.springio.springtest.service;

import com.springio.springtest.domain.Member;
import com.springio.springtest.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository){
    this.memberRepository = memberRepository;
  }


  public Long join(Member member){
    // 같은 이름 이 있는 중복회원 X
//    Optional<Member> result = memberRepository.findByName(member.get());

    validateDuplicateMember(member);
    memberRepository.save(member);

    return member.getId();
  }

  private void validateDuplicateMember(Member member){
    memberRepository.findByName(member.getName()).ifPresent(m -> {
      throw new IllegalStateException("이미 존재하는 회원입니다.");
    });
  }

  public List<Member> findMember(){
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId){
    return memberRepository.findById(memberId);
  }
}
