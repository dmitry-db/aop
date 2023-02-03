package com.example.aspect.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(0)
public class CustomAspect {

    private Logger logger = Logger.getLogger(PerformanceAspectBookService.class.getName());

    @Around("Pointcuts.confuseAnnotation()")
    public Object confuseMethod(ProceedingJoinPoint pjp) throws Throwable {

        logger.info("confuse method");
        pjp.proceed();

        return "OOPS";
    }
}
