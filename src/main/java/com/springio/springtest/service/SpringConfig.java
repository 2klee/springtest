package com.springio.springtest.service;


import com.springio.springtest.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  /*스프링 데이타 jpa*/
  public final MemberRepository memberRepository;

  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }


  //  private final DataSource dataSource; /*jpa 쓰면서 dataSource 필요없어짐*/

//  @Autowired
//  public SpringConfig(DataSource dataSource){
//    this.dataSource = dataSource;
//  }

  /*스프링 jpa 쓰면서 필요없어짐*/
//  private EntityManager em;
//  public SpringConfig(EntityManager em) {
//    this.em = em;
//  }
  @Bean
  public MemberService memberService(){
    return new MemberService(memberRepository);
    /*jpa 에서 밑에 memberRepository() 를 받아왔는데*/
    /*스프링데이터 jpa 에서는 위에 memberRepository를 그대로 가져옴*/
  }

//  @Bean
//  public MemberRepository memberRepository(){
////    return new MemoryMemberRepository();   /*메모리에 저장*/
////    return new JdbcMemberRepository(dataSource); /*DB에 저장*/
////    return new JdbcTemplateMemberRespository(dataSource); /*DB탬플릿을 이용해서 코드 간소화*/
//    return new JpaMemberRepository(em); /*jpa를 이용*/
//  } /*스프링 jpa 쓰면서 필요없어짐*/

}
