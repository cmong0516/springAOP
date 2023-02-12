package hello.aop.proxyvs.code;

import hello.aop.member.MemberService;
import hello.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootTest(properties = {"spring.aop.proxy-target-class=true"})
@Import(ProxyDIAspect.class)
public class ProxyDITest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberServiceImpl memberServiceImpl;

    @Test
    void go() {
        log.info("memberService class = {}" , memberService.getClass());
        log.info("memberServiceImpl class = {}" , memberServiceImpl.getClass());

        memberServiceImpl.hello("hello");
    }
}

// JDK 동적 프록시는 대상 객체인 MemberServiceImpl 타입에 의존관계를 주입할 수 없다.
// CGLIB 프록시는 대상 객체인 MemberServiceImpl 타입에 의존관계 주입을 할 수 있다.
// @SpringBootTest(properties = {"spring.aop.proxy-target-class=true"}) 를 false 로 주면
// memberService = JDK Proxy ok
// memberServiceImpl != JDK Proxy 에러발생.
// 그럼 다 CGLIB 쓰면  ??