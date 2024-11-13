package com.todocodeacademy.springeventstest.service;

import com.todocodeacademy.springeventstest.dto.CreateUserDto;

public interface IUserService {
    String createUser(CreateUserDto createUserDto);
}
