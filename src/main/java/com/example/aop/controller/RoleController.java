package com.example.aop.controller;

import com.example.aop.controller.Request.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("role")
@RestController
public class RoleController {

    @RequestMapping("/save")
    public ResponseEntity<String> saveRole(){
        System.out.println("save role successfully");
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/delete")
    public ResponseEntity<String> deleteRole(@RequestBody Role role){
        System.out.println("the role " + role.getId() + " has been deleted");
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/update")
    public ResponseEntity<String> updateRole(){
        System.out.println("update role successfully");
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/find")
    public String findRole(){
        System.out.println("the role is admin");
        return "find successfully";
    }
}
