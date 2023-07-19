package com.example.aop.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// InvocationHandler实现
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
