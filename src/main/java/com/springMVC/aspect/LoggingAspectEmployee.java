package com.springMVC.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspectEmployee {
    @Around("execution(* com.springMVC.dao.*.*(..))")
    private Object aroundAllRepositoryMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("Метод   " + methodName + "   начал работу");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("Метод   " + methodName + "   закончил работу");
        return object;
    }
}
