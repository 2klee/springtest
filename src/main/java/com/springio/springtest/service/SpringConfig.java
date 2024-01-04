package com.springio.springtest.service;


import com.springio.springtest.repository.JdbcMemberRepository;
import com.springio.springtest.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
  private final DataSource dataSoruce;

  @Autowired
  public SpringConfig(DataSource dataSource){
    this.dataSoruce = dataSource;
  }

  @Bean
  public MemberService memberService(){
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository(){
//    return new MemoryMemberRepository();   /*메모리에 저장*/
    return new JdbcMemberRepository(dataSoruce); /*DB에 저장*/
  }
}
