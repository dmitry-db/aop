package com.example.aspect.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class PerformanceAspectBookService {

    private Logger logger = Logger.getLogger(PerformanceAspectBookService.class.getName());

    @Around("Pointcuts.allMethodBookService()")
    public Object checkPerformanceMethod(ProceedingJoinPoint pjp) throws Throwable {
        Long before = System.currentTimeMillis();
        String bookName = pjp.proceed().toString();
        Long after = System.currentTimeMillis();

        logger.info("Method - " + pjp.getSignature().getName() + " executed " + (after - before) + " milliseconds");

        return bookName;
    }
}
