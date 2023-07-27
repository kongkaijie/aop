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
    @Before(value = "AspectConfig.generatedLog()")
    public void advice() {
        System.out.println("generate advice successfully");
    }

    //环绕增强：是一种非常强大和灵活的通知类型，它可以在目标方法执行之前和之后，甚至可以完全控制目标方法的执行
//    @Around(value = "AspectConfig.generatedLog()")
//    public Object advice(ProceedingJoinPoint joinPoint) throws Throwable {
//        // 1:在目标方法执行之前的逻辑
//        System.out.println("Before method execution");
//
//        // 执行目标方法
//        Object result = null;
//        try {
//            result = joinPoint.proceed();
//        } catch (Exception e) {
//            // 2.处理异常
//            System.out.println("Exception occurred: " + e.getMessage());
//        }
//
//        // 在目标方法执行之后的逻辑
//        System.out.println("After method execution");
//
//        // 3.修改返回值（可选）
//        if (result != null) {
//            result = 77777;
//        }
//
//        // 返回结果
//        return result;
//    }

    //可以用于实现一些异常处理的逻辑
//    @AfterThrowing(value = "AspectConfig.generatedLog()", throwing = "ex")
//    public void advice(Exception ex) {
//        System.out.println("An exception occurred while executing:" + ex.getMessage());
//    }

    //正常返回时才打印，/error接口无法正常返回，所以不打印
//    @AfterReturning(value = "AspectConfig.generatedLog()")
//    public void advice() {
//        System.out.println("return returning successfully");
//    }
}
