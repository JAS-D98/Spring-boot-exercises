package com.jaspercode.springboot_rest_api.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaspercode.springboot_rest_api.api.model.User;
import com.jaspercode.springboot_rest_api.service.UserService;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id){
        return userService.getUser(id);
    }
}
