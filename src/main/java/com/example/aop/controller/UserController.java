package com.example.aop.controller;

import com.example.aop.configuration.Logging;
import com.example.aop.controller.Request.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

    @RequestMapping("/save")
    //第三步：在需要增强的方法上明确标注该类型的注解即可，不需要另外对切点进行统一的配置
    @Logging(value = "save")
    public ResponseEntity<String> saveUser(){
        System.out.println("the user has been saved");
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody User user){
        System.out.println("the user " + user.getId() + " has been deleted");
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/update")
    public ResponseEntity<String> updateUser(){
        System.out.println("the user has been updated");
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/find")
    public String findUser(){
        System.out.println("the user has been found");
        return "find successfully";
    }

    @RequestMapping("/error")
    public String errorThrowing(){
        System.out.println("there is an error" + 10/0);
        return "error";
    }
}
