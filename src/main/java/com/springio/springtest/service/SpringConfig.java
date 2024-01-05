package com.springio.springtest.service;


import com.springio.springtest.repository.JpaMemberRepository;
import com.springio.springtest.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//  private final DataSource dataSoruce; /*jpa 쓰면서 필요없어짐*/

//  @Autowired
//  public SpringConfig(DataSource dataSource){
//    this.dataSoruce = dataSource;
//  }
  private EntityManager em;

  public SpringConfig(EntityManager em) {
    this.em = em;
  }


  @Bean
  public MemberService memberService(){
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository(){
//    return new MemoryMemberRepository();   /*메모리에 저장*/
//    return new JdbcMemberRepository(dataSoruce); /*DB에 저장*/
//    return new JdbcTemplateMemberRespository(dataSoruce);
    return new JpaMemberRepository(em);
  }

}
