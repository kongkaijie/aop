package com.example.aop.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 第二步：实现InvocationHandler，并重写invoke方法，通过invoke方法在目标方法前后增强逻辑
public class LoggingInvocationHandler implements InvocationHandler {
    private final UserService target;

    public LoggingInvocationHandler(UserService target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method: " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("After method: " + method.getName());
        return result;
    }
}
