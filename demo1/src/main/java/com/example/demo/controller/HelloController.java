package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.findAll();
    }
}
