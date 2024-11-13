package com.todocodeacademy.springeventstest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto implements Serializable {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
