package com.example.aop;

import com.example.aop.service.LoggingInvocationHandler;
import com.example.aop.service.UserService;
import com.example.aop.service.UserServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

// 测试类
@SpringBootApplication
public class AopTestApplication {
    public static void main(String[] args) {
        // 创建目标对象
        UserService userService = new UserServiceImpl();

        // 创建InvocationHandler
        InvocationHandler handler = new LoggingInvocationHandler(userService);

        // 第三步：创建代理对象，调用方法
        UserService proxy = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                handler);

        // 通过代理对象调用方法
        proxy.saveUser("John Doe");
    }
}
