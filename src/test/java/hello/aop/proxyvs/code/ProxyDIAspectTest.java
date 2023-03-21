package hello.aop.proxyvs.code;

import hello.aop.member.MemberService;
import hello.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Import(ProxyDIAspect.class)
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=false"})   // JDK 동적 프록시
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=true"})   // CGLIB 동적 프록시
  @SpringBootTest   // 기본 CGLIB
class ProxyDIAspectTest {

  @Autowired
  MemberService memberService;

  @Autowired
  MemberServiceImpl memberServiceImpl;

  @Test
  void go() {
    log.info("memberService class={}", memberService.getClass());
    log.info("memberServiceImpl class={}", memberServiceImpl.getClass());
    memberServiceImpl.hello("hello");
  }
}