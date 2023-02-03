package com.example.aspect.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class BookAspect {

    private Logger logger = Logger.getLogger(BookAspect.class.getName());

    @AfterReturning(value = "Pointcuts.anyMethodInBookService()", returning = "name")
    public void loggingInfoAboutTakeBook(JoinPoint joinPoint, String name) {
        String target = joinPoint.getTarget().toString();
        String methodName = joinPoint.getSignature().getName();

        logger.info("After returning target - " + target + " methodName - " + methodName + " bookName - " + name);
    }
}
