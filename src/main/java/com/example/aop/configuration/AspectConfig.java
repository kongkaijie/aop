package com.example.aop.configuration;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
//@EnableAspectJAutoProxy(proxyTargetClass = true)：启用 AspectJ 代理，并指定代理方式为 CGLIB 代理。如果不指定 proxyTargetClass 参数或者将其设置为 false，则默认使用 JDK 动态代理。
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
public class AspectConfig {

    //集中管理切入点，方便维护和修改。
    //将所有 @Pointcut 相关的配置写在一个类中，可以使得切入点的配置更加清晰明了，便于开发人员统一管理和修改。
    //将不同 Pointcut 切点的业务逻辑单独作为一个类，可以将切面类分解成多个小类，每个小类只关注自己的业务逻辑，从而实现了切面类的解耦，提高了代码的可读性和可维护性。

    @Pointcut("execution(* com.example.aop.controller.*.* (..))")
    public void generatedLog() {
    }
}
