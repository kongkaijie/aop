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
        // 第二步：创建Enhancer对象，用于创建代理对象
        Enhancer enhancer = new Enhancer();
        //第三步：设置目标类为父类
        enhancer.setSuperclass(UserService.class);

        //第四步：设置回调对象，通过实现`MethodInterceptor`接口并重写`intercept()`方法来实现对目标方法的重写
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

        // 当调用Enhancer对象的create()方法时，会生成一个继承自目标类的子类
        UserService proxy = (UserService) enhancer.create();

        // 调用代理对象的方法
        proxy.saveUser();
    }
}
