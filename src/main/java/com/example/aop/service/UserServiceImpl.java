package com.example.aop.service;

// 目标对象的实现
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(String name) {
        System.out.println("Saving user: " + name);
    }
}
