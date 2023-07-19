package com.example.aop;

import com.example.aop.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
// 测试类
@SpringBootApplication
public class AopTestApplication {
    public static void main(String[] args) {
        // 创建目标对象
        UserService userService = new UserService();

        // 创建Enhancer对象，用于创建代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                // 在目标方法调用之前执行增强逻辑
                System.out.println("Before saving user...");

                // 调用目标方法
                Object result = proxy.invokeSuper(obj, args);

                // 在目标方法调用之后执行增强逻辑
                System.out.println("After saving user...");

                return result;
            }
        });

        // 创建代理对象
        UserService proxy = (UserService) enhancer.create();

        // 调用代理对象的方法
        proxy.saveUser();
    }
}
