package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(CallLogAspect.class)
public class CallServiceV0Test {

    @Autowired
    CallServiceV0 callServiceV0;

    @Test
    void external() {
        callServiceV0.external();

        // external() 은 CallLogAspect 가 적용되지만
        // internal() 은 적용되지 않는다.
        // external() 은 프록시를 호출했지만 internal() 은 프록시를 호출하지 않았다.
        // 자바에서 메서드 앞에 별도의 참조가 없으면 this 를 가르쳐 자신의 인스턴스를 가리킨다.
        // 여기서 this 는 프록시가 아니라 실제 대상 객체가 되어 프록시 호출이 되지 않는것.
    }

    @Test
    void internal() {
        callServiceV0.internal();
    }
}
