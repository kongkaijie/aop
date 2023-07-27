package com.example.aop.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//1.第一步：标记一个类为切面类，并且其中定义的方法可以作为切点和通知进行使用。
@Aspect
//将切面类作为一个可被管理的Bean，并能够享受到Spring的自动装配和依赖注入等特性
@Component
public class AspectConfig {

      //第二步：定义切点：指定到某个包下  所有  方法
    @Pointcut("execution(* com.example.aop.controller.*.* (..))")
    public void generatedLog() {
    }

      //指定String返回值类型  的所有方法
//    @Pointcut("execution(String com.example.aop.controller.*.* (..))")
//    public void generatedLog() {
//    }

    //具有指定参数类型  的所有方法  （int） （int,int）
//    @Pointcut("execution(* com.example.aop.controller.*.* (com.example.aop.controller.Request.User))")
//    public void generatedLog() {
//    }

    //通过||来定义多个execution
//    @Pointcut("execution(* com.example.aop.controller.*.* (com.example.aop.controller.Request.User)) || " +
//            "execution(* com.example.aop.controller.*.* (com.example.aop.controller.Request.Role))")
//    public void generatedLog() {
//    }

    //第三步：定义通知类型
    @Before("AspectConfig.generatedLog()")
    public void beforeAdvice() {
        //第四步：定义切入的逻辑
        System.out.println("generate before advice successfully");
    }
}
