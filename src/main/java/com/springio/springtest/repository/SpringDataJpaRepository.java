package com.springio.springtest.repository;

import com.springio.springtest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaRepository extends JpaRepository<Member, Long>, MemberRepository{
  // JpaRepository<Entity, PK 자료형>
  // 인터페이스만 있는 상태에서 jpa 리보피토리를 받고 있으미녀
  // 구현체를 jpa가 자동으로 만들어준다
  // 스프링 빈에 자동 등록

  // JPQL select m from Member as m where m.name =?
  Optional<Member> findByName(String name);
//  Optional<Member> findByNameAndId(String name, Long id);

}
