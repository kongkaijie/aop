package com.example.aop.configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//方法3: 使用注解的方式来装配AOP

//@Before("execution(public * com.itranswarp.learnjava.service.*.*(..))") public void check() {}

//即某个包下面的所有方法都会被这个check()方法拦截。误伤概率很高。即很多不需要AOP代理的方法也被增强。
// 并且，后续新增一些方法，如果我不清楚现有的AOP装配规则，容易被误装配

//所以，在使用AOP时，为了让被装配的方法能清清楚楚地知道自己被安排了，推荐使用注解的方式来装配AOP===》既简单，又能明确标识改方法被AOP装配了，是值得被推荐的。

//第一步：定义logging的注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {
    String value();
}
