package com.example.aop.service;

// 目标对象，需要实现的实现该接口并重写方法
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(String name) {
        System.out.println("Saving user: " + name);
    }
}
