package com.example.petproject.controllers;

import com.example.petproject.dtos.users.UserDto;
import com.example.petproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String addUser(@RequestBody UserDto user) {
        userService.addUser(user);
        return "User save";
    }
}
