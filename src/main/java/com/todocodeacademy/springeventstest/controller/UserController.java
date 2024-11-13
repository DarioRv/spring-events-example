package com.todocodeacademy.springeventstest.controller;

import com.todocodeacademy.springeventstest.dto.CreateUserDto;
import com.todocodeacademy.springeventstest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping()
    public String createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }
}
