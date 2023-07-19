package com.example.aop.service;

public class LoggingAspect {
    public void beforeAdvice() {
        System.out.println("Before saving user...");
    }
}
