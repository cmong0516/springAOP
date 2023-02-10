package hello.aop.member.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// @Retention 어노테이션은 언제까지 생명주기를 가져갈지를 정하는 어노테이션이다.
public @interface ClassAop {
}
