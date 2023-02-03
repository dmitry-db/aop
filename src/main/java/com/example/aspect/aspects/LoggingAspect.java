package com.example.aspect.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());



    @Before("Pointcuts.anyTakeMethodsInService()")
    public void logBeforeTakeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Before logging method name - " +  methodName + " argument - " + args[0]);
    }

    @After("Pointcuts.anyTakeMethodsInService()")
    public void logAfterTakeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("After logging method name - " +  methodName + " argument - " + args[0]);
    }

    @AfterThrowing("Pointcuts.anyTakeMethodsInService()")
    public void logAfterThrowingTakeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("After throwing logging method name - " +  methodName + " argument - " + args[0]);
    }

    @Around("Pointcuts.anyTakeMethodsInService()")
    public Object logAroundTakeMethod(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        logger.info("Before around logging method name - " +  methodName + " argument - " + args[0]);

        String name = (String) pjp.proceed();

        logger.info("After around logging method name - " +  methodName + " argument - " + args[0]);

        if ("bob".equals(args[0])) {
            name = "noBob";
        }
        return name;
    }
}
