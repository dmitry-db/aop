package com.example.aspect.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* com.example.aspect.service.BookService.*(..))")
    public static void allMethodBookService () {}

    @Pointcut("execution(* com.example.aspect.service.TestService.take*(..))")
    public static void anyTakeMethodsInService() {}

    @Pointcut("@annotation(com.example.aspect.annotations.Confuse)")
    public static void confuseAnnotation() {}

    @Pointcut("within(com.example.aspect.service.BookService)")
    public static void anyMethodInBookService() {}
}
