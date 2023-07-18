package com.example.aop.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

      //指定到某个包下  所有  方法
    @Pointcut("execution(* com.example.aop.controller.*.* (..))")
    public void generatedLog() {
    }

      //指定到某个包下   指定String返回值类型  的所有方法
//    @Pointcut("execution(String com.example.aop.controller.*.* (..))")
//    public void generatedLog() {
//    }

    //指定到某个包下   具有指定参数类型  的所有方法  （int） （int,int）
//    @Pointcut("execution(* com.example.aop.controller.*.* (com.example.aop.controller.Request.User))")
//    public void generatedLog() {
//    }

    //通过||来定义多个execution
//    @Pointcut("execution(* com.example.aop.controller.*.* (com.example.aop.controller.Request.User)) || " +
//            "execution(* com.example.aop.controller.*.* (com.example.aop.controller.Request.Role))")
//    public void generatedLog() {
//    }

    @Before("AspectConfig.generatedLog()")
    public void beforeAdvice() {
        System.out.println("generate before advice successfully");
    }
}
