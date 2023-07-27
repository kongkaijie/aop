package com.example.aop.service;
//第一步：需要定义一个目标类。这个类不需要实现任何接口。
public class UserService {
    public void saveUser() {
        System.out.println("Saving user...");
    }
}
