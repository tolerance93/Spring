package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 메소드 호출시 중간에 인터셉트
@Aspect
@Component
public class TimeTraceAop {

    // 패키지 하위에 두 적용함. 보통 패키지 레벨로 많이함
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint jointPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + jointPoint.toString());
        try {
            return jointPoint.proceed(); // control + T: inline
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + jointPoint.toString() + " " + timeMs);
        }
    }


}
