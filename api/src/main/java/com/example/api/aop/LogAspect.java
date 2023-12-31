package com.example.api.aop;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {

    static Logger logger = LoggerFactory.getLogger("com.example.api.aop.LogAspect");
    @Pointcut("within(com.example.api..*)")
    private void isApi(){}

    @Around("isApi()")
    public Object loggingAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        stopWatch.stop();

        logger.info("Logging : {} {} {}", joinPoint.getSignature().getName(),
            Arrays.toString(joinPoint.getArgs()), stopWatch.getTotalTimeSeconds());

        return result;
    }
}
