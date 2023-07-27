package com.example.aop.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogConfig {
    //第二步：对标有该注解的方法进行增强
    @Around(value = "@annotation(logging)")
    public Object advice(ProceedingJoinPoint joinPoint, Logging logging) throws Throwable {
        System.out.println("start to generate advice");
        Object result = joinPoint.proceed();
        System.out.println("generate advice successfully");

        return result;
    }
}
