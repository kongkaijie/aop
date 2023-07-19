package com.example.aop.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

    @Pointcut("execution(* com.example.aop.controller.*.* (..))")
    public void generatedLog() {
    }

    //在切点前发送通知
//    @Before(value = "AspectConfig.generatedLog()")
//    public void advice() {
//        System.out.println("generate advice successfully");
//    }

    //环绕增强
//    @Around(value = "AspectConfig.generatedLog()")
//    public Object advice(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("before it proceed");//等价于@Before注解
//        Object result = pjp.proceed();//执行目标方法，并将执行结果返回
//        System.out.println("after it proceed");//等价于@After注解
//        return result;
//    }

    //
//    @AfterThrowing(value = "AspectConfig.generatedLog()", throwing = "ex")
//    public void advice(Exception ex) {
//        System.out.println("An exception occurred while executing:" + ex.getMessage());
//    }

    @AfterReturning(value = "AspectConfig.generatedLog()")
    public void advice() {
        System.out.println("return returning successfully");
    }
}
