package com.example.aop.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogConfig {



    @Before(value = "AspectConfig.generatedLog()")
    public void advice() {
        System.out.println("generate advice successfully");
    }
}
