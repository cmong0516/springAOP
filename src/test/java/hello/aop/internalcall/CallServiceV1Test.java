package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(CallLogAspect.class)
class CallServiceV1Test {

    @Autowired
    CallServiceV1 callServiceV1;

    @Test
    void external() {
        callServiceV1.external();
    }
}

// 순환참조는 SpringBoot 2.6 이후부터 금지되었다.
// spring.main.allow-circular-references=true 를 추가해주어야 동작한다.

// set 메서드를 통해 this 로 자동 호출되는 실제 객체가 아니라 프록시를 이용하여
// log가 출력되었다.